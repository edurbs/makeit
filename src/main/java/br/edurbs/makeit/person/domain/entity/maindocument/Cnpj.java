package br.edurbs.makeit.person.domain.entity.maindocument;
import org.hibernate.validator.constraints.br.CNPJ;
import br.edurbs.makeit.person.domain.entity.DomainEntityAbstract;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Builder
public class Cnpj extends DomainEntityAbstract implements MainDocument {

    @NotBlank
    @CNPJ
    private String number;

    // public Cnpj(String number)
    //         throws InvalidCnpjException {
    //     this.setNumber(number);
    // }

    // @Override
    // public void setNumber(String number) throws InvalidCnpjException {
    //     String oldCnpj = this.number;
    //     String newCnpj = number.replaceAll("\\D+", "");
    //     if(newCnpj.isBlank()){
    //         throw new InvalidCnpjException();
    //     }
    //     if (!oldCnpj.equals(newCnpj)) {
    //         this.number = newCnpj;
    //         if (!validator.isValid(this)) {
    //             this.number = oldCnpj;
    //             throw new InvalidCnpjException();
    //         }
    //     }
    // }

}
