package com.elias.reflections;

import com.elias.reflections.model.dto.AnimalDTO;
import com.elias.reflections.model.entity.Animal;
import com.elias.reflections.reflection.Transformator;
import com.elias.reflections.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReflectionsApplication implements CommandLineRunner {

    @Autowired
    private AnimalService animalService;

    public static void main(String[] args) {
        SpringApplication.run(ReflectionsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Animal animal = animalService.salvarNovoAnimal();

        AnimalDTO animalDTO = new Transformator().transform(animal);
        System.out.println(animalDTO.toString());
    }
}
