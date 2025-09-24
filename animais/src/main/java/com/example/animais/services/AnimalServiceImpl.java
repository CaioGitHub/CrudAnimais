package com.example.animais.services;

import com.example.animais.dtos.AnimalDTO;
import com.example.animais.dtos.AnimalResponseDTO;
import com.example.animais.models.Animal;
import com.example.animais.repositories.AnimalRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AnimalServiceImpl implements AnimalService {

    private final AnimalRepository animalRepository;

    public AnimalServiceImpl(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<AnimalResponseDTO> getAllAnimals() {
        return animalRepository.findAll().stream().map(this::toDto).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<AnimalResponseDTO> getAnimalById(Long id) {
        return animalRepository.findById(id).map(this::toDto);
    }

    @Override
    public AnimalResponseDTO createAnimal(AnimalDTO animalDTO) {
        Animal animal = toEntity(animalDTO);
        return toDto(animalRepository.save(animal));
    }

    @Override
    public Optional<AnimalResponseDTO> updateAnimal(Long id, AnimalDTO animalDTO) {
        return animalRepository.findById(id).map(existing -> {
            existing.setNome(animalDTO.nome());
            existing.setEspecie(animalDTO.especie());
            existing.setIdade(animalDTO.idade());
            return toDto(animalRepository.save(existing));
        });
    }

    @Override
    public void deleteAnimal(Long id) {
        animalRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AnimalResponseDTO> getAnimalsByEspecie(String especie) {
        return animalRepository.findByEspecieIgnoreCase(especie).stream().map(this::toDto).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<AnimalResponseDTO> getAnimalsOlderThan(int idade) {
        return animalRepository.findByIdadeGreaterThan(idade).stream().map(this::toDto).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<AnimalResponseDTO> getAnimalsByNome(String nome) {
        return animalRepository.findByNomeContainingIgnoreCase(nome).stream().map(this::toDto).toList();
    }

    private AnimalResponseDTO toDto(Animal animal) {
        return new AnimalResponseDTO(animal.getId(), animal.getNome(), animal.getEspecie(), animal.getIdade());
    }

    private Animal toEntity(AnimalDTO dto) {
        return Animal.builder()
                .nome(dto.nome())
                .especie(dto.especie())
                .idade(dto.idade())
                .build();
    }
}
