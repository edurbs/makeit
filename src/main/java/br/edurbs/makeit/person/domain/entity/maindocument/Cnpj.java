package br.edurbs.makeit.person.domain.entity.maindocument;
import org.hibernate.validator.constraints.br.CNPJ;
import br.edurbs.makeit.person.domain.entity.exception.InvalidCnpjException;
import br.edurbs.makeit.person.domain.validation.ValidatorService;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Cnpj implements MainDocument {

    @NotBlank
    @CNPJ
    @Setter(AccessLevel.NONE)
    private String number = "";

    @Getter(AccessLevel.NONE)
    private final ValidatorService validator;

    public Cnpj(String number, ValidatorService validation)
            throws InvalidCnpjException {
        this.validator = validation;
        this.setNumber(number);
    }

    @Override
    public void setNumber(String number) throws InvalidCnpjException {
        String oldCnpj = this.number;
        String newCnpj = number.replaceAll("\\D+", "");
        if(newCnpj.isBlank()){
            throw new InvalidCnpjException();
        }
        if (!oldCnpj.equals(newCnpj)) {
            this.number = newCnpj;
            if (!validator.isValid(this)) {
                this.number = oldCnpj;
                throw new InvalidCnpjException();
            }
        }
    }

}
