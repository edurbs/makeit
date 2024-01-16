package br.edurbs.makeit.person.domain.person.maindocument;

import br.edurbs.makeit.person.domain.ValueObject;
import br.edurbs.makeit.person.domain.validation.annotation.ValidCNPJ;


public record Cnpj(@ValidCNPJ(message = "CNPJ inválido") String value)
		implements MainDocument, ValueObject {

	public Cnpj(String value) {
		this.value = value.replaceAll("\\D+", "");
		this.validate();
	}

	public String withMask() {
		var cnpj = this.value;
		cnpj = cnpj.substring(0, 2)
				+ "." + cnpj.substring(2, 5)
				+ "." + cnpj.substring(5, 8)
				+ "/" + cnpj.substring(8, 12)
				+ "-" + cnpj.substring(12, 14);
		return cnpj;
	}

}
