package com.example.animais.services;

import com.example.animais.dtos.AnimalDTO;
import com.example.animais.dtos.AnimalResponseDTO;
import com.example.animais.models.Animal;
import com.example.animais.repositories.AnimalRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface AnimalService {
    List<AnimalResponseDTO> getAllAnimals();
    Optional<AnimalResponseDTO> getAnimalById(Long id);
    AnimalResponseDTO createAnimal(AnimalDTO animalDTO);
    Optional<AnimalResponseDTO> updateAnimal(Long id, AnimalDTO animalDTO);
    void deleteAnimal(Long id);
    List<AnimalResponseDTO> getAnimalsByEspecie(String especie);
    List<AnimalResponseDTO> getAnimalsOlderThan(int idade);
    List<AnimalResponseDTO> getAnimalsByNome(String nome);
}
