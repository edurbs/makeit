package br.edurbs.makeit.person.domain.person.maindocument;
import org.hibernate.validator.constraints.br.CNPJ;
import br.edurbs.makeit.person.domain.DomainEntityValidation;
import jakarta.validation.constraints.NotBlank;
import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = false)
public class Cnpj extends DomainEntityValidation implements MainDocument {

    @NotBlank
    @CNPJ
    private String number;

    public Cnpj (String number){
        this.number = number.replaceAll("\\D+", "");
    }
}
