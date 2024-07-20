package pooproject.bookstation.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import pooproject.bookstation.APIResponse.UpdateAPIResponse;
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

    @PostMapping("/cadastrar")
    public ResponseEntity<LivroIdDTO> createLivro(@RequestBody LivroRequestDTO body, UriComponentsBuilder uriComponentsBuilder){
        LivroIdDTO livroIdDTO = this.livroService.createLivro(body);
        var uri = uriComponentsBuilder.path("/item/livro/{id}").buildAndExpand(livroIdDTO.itemId()).toUri();
        return ResponseEntity.created(uri).body(livroIdDTO);
    }

    @PutMapping("/atualizar-livro/{idLivro}")
    public ResponseEntity<UpdateAPIResponse> updateLivro(@RequestBody LivroRequestDTO body, @PathVariable String idLivro){
        LivroIdDTO livroIdDTO = this.livroService.updateLivro(body, idLivro);
        UpdateAPIResponse response = new UpdateAPIResponse("Book update success", livroIdDTO.livroID());
        return ResponseEntity.ok(response);
    }

}
