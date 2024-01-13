package br.edurbs.makeit.person.domain.person;

import br.edurbs.makeit.person.domain.ValueObject;
import jakarta.validation.constraints.NotBlank;

public record Email(@NotBlank @jakarta.validation.constraints.Email String value) implements ValueObject {
    public Email(String value) {
        this.value = value;
        this.validate();
    }
}
