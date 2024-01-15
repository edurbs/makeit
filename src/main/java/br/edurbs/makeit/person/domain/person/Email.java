package br.edurbs.makeit.person.domain.person;

import br.edurbs.makeit.person.domain.DomainEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Email implements DomainEntity {
    @NotBlank
    String id;

    @NotNull
    EmailType emailType;

    @NotNull
    EmailAddress emailAddress;

    public Email(@NotBlank String id, EmailType emailType, EmailAddress emailAddress) {
        this.id = id;
        this.emailType = emailType;
        this.emailAddress = emailAddress;
        this.validate();
    }

}
