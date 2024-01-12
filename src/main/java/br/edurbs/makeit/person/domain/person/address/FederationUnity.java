package br.edurbs.makeit.person.domain.person.address;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class FederationUnity {

    String id;

    String acronym;

    @NotBlank
    String name;

    @NonNull
    Country country;
}
