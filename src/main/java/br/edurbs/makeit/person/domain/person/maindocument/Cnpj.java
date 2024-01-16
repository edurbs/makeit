package br.edurbs.makeit.person.domain.person.maindocument;

import br.edurbs.makeit.person.domain.ValueObject;
import br.edurbs.makeit.person.domain.validation.annotation.ValidCNPJ;


public record Cnpj(@ValidCNPJ(message = "CNPJ inválido") String value)
		implements MainDocument, ValueObject {

	public Cnpj(String value) {
		this.value = value.replaceAll("\\D+", "");
		this.validate();
	}

}
