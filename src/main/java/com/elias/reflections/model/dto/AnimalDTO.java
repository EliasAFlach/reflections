package com.elias.reflections.model.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AnimalDTO {

    private String nome;
    private LocalDate dataNascimento;
    private String raca;

    @Override
    public String toString() {
        return "Dados do animal: \n Nome: %s, \n Data de Nascimento: %s, \n Raca: %s \n Idade: %s anos"
                .formatted(nome, dataNascimento, raca, LocalDate.now().getYear() - dataNascimento.getYear());
    }
}
