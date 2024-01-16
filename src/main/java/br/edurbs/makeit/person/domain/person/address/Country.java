package br.edurbs.makeit.person.domain.person.address;

import br.edurbs.makeit.person.domain.ValueObject;
import jakarta.validation.constraints.NotBlank;


public record Country(@NotBlank String id, @NotBlank String value) implements ValueObject {
	public Country(String id, String value) {
		this.id = id;
		this.value = value;
		this.validate();
	}

	// TODO tests
}
