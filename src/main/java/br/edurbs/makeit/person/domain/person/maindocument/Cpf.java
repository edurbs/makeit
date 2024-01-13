package br.edurbs.makeit.person.domain.person.maindocument;

import org.hibernate.validator.constraints.br.CPF;
import br.edurbs.makeit.person.domain.DomainEntityValidation;
import jakarta.validation.constraints.NotBlank;
import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = false)
public class Cpf extends DomainEntityValidation implements MainDocument {

    @NotBlank
    @CPF
    private String number;

    public Cpf (String number){
        this.number = number.replaceAll("\\D+", "");
    }

}
