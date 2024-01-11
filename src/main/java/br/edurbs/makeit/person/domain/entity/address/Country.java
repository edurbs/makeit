package br.edurbs.makeit.person.domain.entity.address;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class Country {
    String id;

    @NotBlank
    String name;
}
