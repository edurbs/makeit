package br.edurbs.makeit.person.domain.person;

import br.edurbs.makeit.person.domain.DomainEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EmailAddress implements DomainEntity {
    @NotBlank
    String id;

    @NotNull
    EmailType emailType;

    @NotNull
    Email email;

    public EmailAddress(String id, EmailType emailType, Email email) {
        this.id = id;
        this.emailType = emailType;
        this.email = email;
        this.validate();
    }

}
