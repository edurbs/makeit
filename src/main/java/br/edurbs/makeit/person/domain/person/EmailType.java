package br.edurbs.makeit.person.domain.person;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class EmailType {

    @NotNull
    @NotBlank
    final String id;

    String description;
}
