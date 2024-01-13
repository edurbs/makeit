package br.edurbs.makeit.person.domain.person.maindocument;

import org.hibernate.validator.constraints.br.CPF;
import br.edurbs.makeit.person.domain.ValueObject;
import jakarta.validation.constraints.NotBlank;

public record Cpf(@CPF @NotBlank String value) implements MainDocument, ValueObject {
    public Cpf (String value){
        this.value = value.replaceAll("\\D+", "");
        this.validate();
    }
}
