package com.elias.reflections.service;

import com.elias.reflections.model.entity.Animal;
import com.elias.reflections.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AnimalService {
    @Autowired
    private AnimalRepository animalRepository;

    public Animal salvarNovoAnimal() {
        Animal novoAnimal = new Animal();
        novoAnimal.setNome("Rex");
        novoAnimal.setDataNascimento(LocalDate.of(2020, 5, 15));
        novoAnimal.setRaca("Salsicha");

        return animalRepository.save(novoAnimal);
    }
}
