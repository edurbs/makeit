package br.edurbs.makeit.person.domain.person.maindocument;

import br.edurbs.makeit.person.domain.ValueObject;
import br.edurbs.makeit.person.domain.validation.MyCpfValidator;
import jakarta.validation.constraints.NotBlank;

public record Cpf(@NotBlank String value) implements MainDocument, ValueObject {
    public Cpf (String value){
		this.value = value.replaceAll("\\D+", "");
		new MyCpfValidator().validate(this.value);
        this.validate();
    }
}
