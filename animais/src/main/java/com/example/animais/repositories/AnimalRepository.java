package com.example.animais.repositories;

import com.example.animais.models.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
    List<Animal> findByEspecieIgnoreCase(String especie);
    List<Animal> findByIdadeGreaterThan(int idade);
}
