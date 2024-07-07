package pooproject.bookstation.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/locatario")
public class LocatarioController {
    @GetMapping
    public ResponseEntity<String> getAutor(){
        return ResponseEntity.ok("sucesso");
    };
}
