package br.edurbs.makeit.person.domain.entity.address;

import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class Address {

    String id;
    String zipCode;

    @NotBlank
    @Size(min = 3)
    String street;

    String number;
    String complement;
    String neighborhood;

    @Nonnull
    City city;

    boolean isZipCodeValid() {
        return (zipCode.isBlank())
                || (!zipCode.isBlank()
                        && city.getCountry().getName().equals("Brasil")
                        && !zipCode.matches("\\d{2}.\\d{3}-\\d{3}"));
    }
}
