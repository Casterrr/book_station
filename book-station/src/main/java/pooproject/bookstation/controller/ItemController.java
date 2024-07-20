package pooproject.bookstation.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import pooproject.bookstation.APIResponse.DeleteAPIResponse;
import pooproject.bookstation.dto.item.ItemIdDTO;
import pooproject.bookstation.dto.item.ItemRequestDTO;
import pooproject.bookstation.dto.item.ItemResponseDTO;
import pooproject.bookstation.dto.livro.LivroResponseDTO;
import pooproject.bookstation.services.ItemService;
import pooproject.bookstation.services.LivroService;

@RestController
@RequestMapping("/item")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService service;
    private final LivroService livroService;
    @GetMapping("/{itemId}")
    public ResponseEntity<LivroResponseDTO> getItem(@PathVariable String itemId){
        ItemResponseDTO item = this.service.getItemDetail(itemId);
        LivroResponseDTO livro = this.livroService.getLivroDetail(itemId);
        return ResponseEntity.ok(livro);
    };

    //@PostMapping("/create-item")
    public ResponseEntity<ItemIdDTO> createItem(@RequestBody ItemRequestDTO body, UriComponentsBuilder uriComponentsBuilder){
        ItemIdDTO idDTO = this.service.createItem(body);
        var uri = uriComponentsBuilder.path("/events/{id}").buildAndExpand(idDTO.itemID()).toUri();
        return ResponseEntity.created(uri).body(idDTO);
    };

    @DeleteMapping("/delete/{idItem}")
    public ResponseEntity<?> deleteItem(@PathVariable String idItem){
        int deleteItem = this.service.deleteItem(idItem);
        if (deleteItem == 200){
            DeleteAPIResponse response = new DeleteAPIResponse("Item successful delete");
            return ResponseEntity.ok(response);
        } else if (deleteItem == 404) {
            DeleteAPIResponse response = new DeleteAPIResponse("Item not found");
            return ResponseEntity.status(deleteItem).body(response);
        } else{
            DeleteAPIResponse response = new DeleteAPIResponse("Delete item error");
            return ResponseEntity.status(deleteItem).body(response);
        }

    };
}
