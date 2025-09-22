package com.example.animais.services;

import com.example.animais.dtos.AnimalDTO;
import com.example.animais.models.Animal;
import com.example.animais.repositories.AnimalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {
    private final AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    public Optional<Animal> getAnimalById(Long id) {
        return animalRepository.findById(id);
    }

    public Animal createAnimal(AnimalDTO animalDTO) {
        Animal animal = Animal.builder()
                .nome(animalDTO.nome())
                .especie(animalDTO.especie())
                .idade(animalDTO.idade())
                .build();
        return animalRepository.save(animal);
    }

    public Optional<Animal> updateAnimal(Long id, AnimalDTO animalDTO) {
        return animalRepository.findById(id).map(existing -> {
            existing.setNome(animalDTO.nome());
            existing.setEspecie(animalDTO.especie());
            existing.setIdade(animalDTO.idade());
            return animalRepository.save(existing);
        });
    }

    public void deleteAnimal(Long id) {
        animalRepository.deleteById(id);
    }

    public List<Animal> getAnimalsByEspecie(String especie) {
        return animalRepository.findByEspecieIgnoreCase(especie);
    }

    public List<Animal> getAnimalsOlderThan(int idade) {
        return animalRepository.findByIdadeGreaterThan(idade);
    }
}
