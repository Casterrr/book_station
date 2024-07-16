package pooproject.bookstation.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
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
        //if (item.getItemDTO().indTipo().equals("L")){
        LivroResponseDTO livro = this.livroService.getLivroDetail(itemId);
        return ResponseEntity.ok(livro);
        //}
        //return ResponseEntity.ok(item);
    };

    //@PostMapping("/create-item")
    public ResponseEntity<ItemIdDTO> createItem(@RequestBody ItemRequestDTO body, UriComponentsBuilder uriComponentsBuilder){
        ItemIdDTO idDTO = this.service.createItem(body);
        var uri = uriComponentsBuilder.path("/events/{id}").buildAndExpand(idDTO.itemID()).toUri();
        return ResponseEntity.created(uri).body(idDTO);
    };

    //@DeleteMapping("/delete/{idItem}")
    //public ResponseEntity<ItemIdDTO> deleteItem(@PathVariable Integer idItem){
        //ItemIdDTO idDTO = this.service;
        //return ResponseEntity.created(uri).body(idDTO);
    //};
}
