package br.edurbs.makeit.person.domain.person.maindocument;

import br.edurbs.makeit.person.domain.ValueObject;
import br.edurbs.makeit.person.domain.validation.MyCnpjValidator;


public record Cnpj( String value) implements MainDocument, ValueObject {

    public Cnpj(String value) {
		this.value = value.replaceAll("\\D+", "");
		new MyCnpjValidator().validate(this.value);
        this.validate();
    }

}
