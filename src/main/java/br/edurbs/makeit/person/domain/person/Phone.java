package br.edurbs.makeit.person.domain.person;

import br.edurbs.makeit.person.domain.DomainEntity;
import br.edurbs.makeit.person.domain.validation.PhoneValidator;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record Phone(@NotNull PhoneType phoneType, @NotBlank String number, PhoneValidator phoneValidator) implements DomainEntity {

    public Phone(PhoneType phoneType, String number, PhoneValidator phoneValidator) {
        this.phoneType = phoneType;
        this.number = number;
        this.phoneValidator = phoneValidator;
        validate();
        phoneValidator.validate(number);
    }

	// TODO add @Phone to validate

}
