package br.edurbs.makeit.person.domain.entity.maindocument;

import org.hibernate.validator.constraints.br.CPF;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class Cpf implements MainDocument {

    @NotBlank
    @CPF
    private String number;

}
