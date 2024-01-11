package br.edurbs.makeit.person.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Gender {
    MALE("Masculino"),
    FEMALE("Feminino"),
    OTHER("Outro"),
    NONE("Não informado");

    private final String name;
}
