package br.edurbs.makeit.person.domain.entity.maindocument;

import org.hibernate.validator.constraints.br.CPF;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public final class Cpf implements MainDocument {

    @NotBlank
    @CPF
    private String number;
 // TODO CPF validation


}
