package br.edurbs.makeit.person.domain.entity.address;

import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class City {

    String id;

    @NotBlank
    String name;

    FederationUnity uf;

    @Nonnull
    Country country;

}
