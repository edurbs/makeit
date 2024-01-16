package br.edurbs.makeit.person.domain.person.address;

import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class Address {

	@NotBlank
	String id;

    ZipCode zipCode;

    @NotBlank
    @Size(min = 3)
    String street;

    String number;
    String complement;
    String neighborhood;

	@Nonnull
	City city;

	@Nonnull
	Country country;

}
