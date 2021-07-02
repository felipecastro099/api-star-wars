package br.meli.starwars.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.meli.starwars.repositories.PersonagemRepository;

@RestController
@RequestMapping("/star-wars")
public class PersonagemController {
    @Autowired
    private PersonagemRepository personagemRepository;

    @GetMapping()
    public ResponseEntity<?> index(){
        return ResponseEntity.ok(personagemRepository.findAll());
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> show(@PathVariable String name){
        return ResponseEntity.ok(personagemRepository.getPerName(name));
    }
}
