package br.edurbs.makeit.person.domain.entity.document;

import jakarta.validation.Validation;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class Rg implements Document {
    @NonNull
    DocumentType documentType;

    @NotBlank
    String number;

    @Override
    public boolean isValid() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        var validator = factory.getValidator();
        return validator.validate(this).isEmpty(); //TODO make test
    }

}
