package pooproject.bookstation.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import pooproject.bookstation.dto.item.ItemIdDTO;
import pooproject.bookstation.dto.item.ItemRequestDTO;
import pooproject.bookstation.dto.item.ItemResponseDTO;
import pooproject.bookstation.dto.livro.LivroIdDTO;
import pooproject.bookstation.dto.livro.LivroRequestDTO;
import pooproject.bookstation.dto.livro.LivroResponseDTO;
import pooproject.bookstation.services.LivroService;

@RestController
@RequestMapping("/item/livro")
@RequiredArgsConstructor
public class LivroController {

    private final LivroService livroService;

    @GetMapping("/{livroID}")
    public ResponseEntity<LivroResponseDTO> getLivro(@PathVariable String livroId){
        LivroResponseDTO livro = this.livroService.getLivroDetail(livroId);
        return ResponseEntity.ok(livro);
    };

    //public ResponseEntity<String> getAutor(){
        //return ResponseEntity.ok("sucesso");
    //}

    @PostMapping("/cadastrar")
    public ResponseEntity<ItemIdDTO> createLivro(@RequestBody LivroRequestDTO body, UriComponentsBuilder uriComponentsBuilder){
        ItemIdDTO itemIdDTO = this.livroService.createLivro(body);
        var uri = uriComponentsBuilder.path("/item/livro/{id}").buildAndExpand(itemIdDTO.itemID()).toUri();
        return ResponseEntity.created(uri).body(itemIdDTO);
    }
}
