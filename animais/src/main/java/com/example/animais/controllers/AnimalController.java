package com.example.animais.controllers;

import com.example.animais.dtos.AnimalDTO;
import com.example.animais.dtos.AnimalResponseDTO;
import com.example.animais.models.Animal;
import com.example.animais.services.AnimalService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/animais")
public class AnimalController {
    private final AnimalService animalService;

    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping
    public List<AnimalResponseDTO> getAll() {
        return animalService.getAllAnimals();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnimalResponseDTO> getById(@PathVariable Long id) {
        return animalService.getAnimalById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody AnimalDTO animalDTO, BindingResult result) {
        if(result.hasErrors()) {
            Map<String, String> erros = new HashMap<>();
            result.getFieldErrors().forEach(erro ->
                    erros.put(erro.getField(), erro.getDefaultMessage()));
            return ResponseEntity.badRequest().body(erros);
        }
        AnimalResponseDTO animal = animalService.createAnimal(animalDTO);
        return ResponseEntity.ok(animal);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody AnimalDTO animalDTO, BindingResult result) {
        if(result.hasErrors()) {
            Map<String, String> erros = new HashMap<>();
            result.getFieldErrors().forEach(erro ->
                    erros.put(erro.getField(), erro.getDefaultMessage()));
            return ResponseEntity.badRequest().body(erros);
        }
        return animalService.updateAnimal(id, animalDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return animalService.getAnimalById(id)
                .map(existing -> {
                    animalService.deleteAnimal(id);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/especie/{especie}")
    public List<AnimalResponseDTO> getByEspecie(@PathVariable String especie) {
        return animalService.getAnimalsByEspecie(especie);
    }

    @GetMapping("/idadeMaiorQue/{idade}")
    public List<AnimalResponseDTO> getByIdadeMaiorQue(@PathVariable int idade) {
        return animalService.getAnimalsOlderThan(idade);
    }

    @GetMapping("/nome/{nome}")
    public List<AnimalResponseDTO> getByNome(@PathVariable String nome) {
        return animalService.getAnimalsByNome(nome);
    }
}
