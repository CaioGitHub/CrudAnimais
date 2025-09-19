package com.example.animais.controllers;

import com.example.animais.models.Animal;
import com.example.animais.services.AnimalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animais")
public class AnimalController {
    private final AnimalService animalService;

    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping
    public List<Animal> getAll() {
        return animalService.getAllAnimals();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Animal> getById(@PathVariable Long id) {
        return animalService.getAnimalById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Animal create(@RequestBody Animal animal) {
        return animalService.createAnimal(animal);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Animal> update(@PathVariable Long id, @RequestBody Animal animal) {
        return animalService.getAnimalById(id)
                .map(existing -> {
                    existing.setNome(animal.getNome());
                    existing.setEspecie(animal.getEspecie());
                    existing.setIdade(animal.getIdade());
                    return ResponseEntity.ok(animalService.createAnimal(existing));
                })
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
    public List<Animal> getByEspecie(@PathVariable String especie) {
        return animalService.getAnimalsByEspecie(especie);
    }

    @GetMapping("/idadeMaiorQue/{idade}")
    public List<Animal> getByIdadeMaiorQue(@PathVariable int idade) {
        return animalService.getAnimalsOlderThan(idade);
    }

    @GetMapping("/nome/{nome}")
    public List<Animal> getByNome(@PathVariable String nome) {
        return animalService.getAllAnimals().stream()
                .filter(animal -> animal.getNome().equalsIgnoreCase(nome))
                .toList();
    }
}
