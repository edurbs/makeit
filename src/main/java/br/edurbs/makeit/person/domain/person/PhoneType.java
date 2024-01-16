package br.edurbs.makeit.person.domain.person;

import br.edurbs.makeit.person.domain.ValueObject;
import jakarta.validation.constraints.NotBlank;

public record PhoneType(@NotBlank String value) implements ValueObject {
	public PhoneType(String value) {
		this.value = value;
		validate();
    }
}
