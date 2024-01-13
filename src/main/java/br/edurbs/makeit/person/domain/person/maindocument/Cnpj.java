package br.edurbs.makeit.person.domain.person.maindocument;

import org.hibernate.validator.constraints.br.CNPJ;
import br.edurbs.makeit.person.domain.ValueObject;
import jakarta.validation.constraints.NotBlank;

public record Cnpj(@NotBlank @CNPJ String value) implements MainDocument, ValueObject {

    public Cnpj(String value) {
        this.value = value.replaceAll("\\D+", "");
        this.validate();
    }

}
