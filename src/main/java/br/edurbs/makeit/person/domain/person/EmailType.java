package br.edurbs.makeit.person.domain.person;

import br.edurbs.makeit.person.domain.ValueObject;
import jakarta.validation.constraints.NotBlank;

public record EmailType (@NotBlank String value) implements ValueObject {
    public EmailType(String value) {
        this.value = value;
        this.validate();
    }
}
