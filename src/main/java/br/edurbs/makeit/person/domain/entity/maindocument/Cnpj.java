package br.edurbs.makeit.person.domain.entity.maindocument;

import org.hibernate.validator.constraints.br.CNPJ;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class Cnpj implements MainDocument {

    @NotBlank
    @CNPJ
    private String number;

}
