package br.edurbs.makeit.person.domain.person;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class EmailType {

    @NotBlank
    final String id;

    @NotBlank
    String description;
}
