package br.edurbs.makeit.person.domain.person;

import br.edurbs.makeit.person.domain.ValueObject;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record EmailAddress(@NotBlank @Email String value) implements ValueObject {
    public EmailAddress(String value) {
        this.value = value;
        this.validate();
    }
}
