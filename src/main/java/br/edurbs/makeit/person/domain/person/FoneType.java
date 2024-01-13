package br.edurbs.makeit.person.domain.person;

import br.edurbs.makeit.person.domain.ValueObject;
import jakarta.validation.constraints.NotBlank;

public record FoneType(@NotBlank String value) implements ValueObject {
    public FoneType(String value) {
        this.value = value;
        validate();
    }
}
