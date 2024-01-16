package br.edurbs.makeit.person.domain.person.address;

import br.edurbs.makeit.person.domain.ValueObject;
import br.edurbs.makeit.person.domain.validation.annotation.ValidZipCode;

public record ZipCode(@ValidZipCode(country = "Brasil") String value) implements ValueObject {
	public ZipCode(String value) {
		this.value = value.replaceAll("\\D*", "");
		validate();
	}
}
