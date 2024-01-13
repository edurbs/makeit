package br.edurbs.makeit.person.domain.person;

import br.edurbs.makeit.person.domain.ValueObject;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EmailAddress(@NotNull EmailType emailType, @NotBlank @Email String value)
        implements ValueObject {

    public EmailAddress(EmailType emailType, String value) {
        this.emailType = emailType;
        this.value = value;
        this.validate();
    }
}
