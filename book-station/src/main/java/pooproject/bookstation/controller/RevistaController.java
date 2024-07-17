package pooproject.bookstation.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import pooproject.bookstation.dto.revista.RequestRevistaDTO;
import pooproject.bookstation.dto.revista.RevistaIdDTO;
import pooproject.bookstation.services.RevistaService;

@RestController
@RequestMapping("item/revista")
@RequiredArgsConstructor
public class RevistaController {

    private final RevistaService service;

    @GetMapping
    public ResponseEntity<String> getAutor(){
        return ResponseEntity.ok("sucesso");
    };

    @PostMapping("/cadastrar")
    public ResponseEntity<RevistaIdDTO> createRevista(@RequestBody RequestRevistaDTO body, UriComponentsBuilder uriComponentsBuilder){
        RevistaIdDTO revistaIdDTO = this.service.createRevista(body);
        var uri = uriComponentsBuilder.path("/item/livro/{id}").buildAndExpand(revistaIdDTO.idRevista()).toUri();
        return ResponseEntity.created(uri).body(revistaIdDTO);
    }
}
