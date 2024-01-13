package br.edurbs.makeit.person.domain.person;

import br.edurbs.makeit.person.domain.ValueObject;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EmailAddress(@NotBlank String id, @NotNull EmailType emailType,
        @NotBlank @Email String value) implements ValueObject {

    public EmailAddress(String id, EmailType emailType, String value) {
        this.id = id;
        this.emailType = emailType;
        this.value = value;
        this.validate();
    }

}
