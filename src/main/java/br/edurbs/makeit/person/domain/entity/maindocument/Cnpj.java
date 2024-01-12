package br.edurbs.makeit.person.domain.entity.maindocument;
import org.hibernate.validator.constraints.br.CNPJ;
import br.edurbs.makeit.person.domain.entity.DomainEntityAbstract;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;

@Data
@EqualsAndHashCode(callSuper = false)
@Builder
public final class Cnpj extends DomainEntityAbstract implements MainDocument {

    @NotBlank
    @CNPJ
    @Setter(AccessLevel.NONE)
    private String number;

    public static class CnpjBuilder{
        public CnpjBuilder number(String number){
            this.number = number.replaceAll("\\D+", "");
            return this;
        }
    }
}
