package br.edurbs.makeit.person.domain.entity.maindocument;

import org.hibernate.validator.constraints.br.CPF;
import br.edurbs.makeit.person.domain.entity.exception.InvalidCnpjException;
import br.edurbs.makeit.person.domain.entity.exception.InvalidCpfException;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Value;

@Value
@Data
public class Cpf implements MainDocument {

    @NotBlank
    @CPF
    private String number;
 // TODO CPF validation

    @Override
    public void setNumber(String number) throws InvalidCnpjException, InvalidCpfException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setNumber'");
    }
}
