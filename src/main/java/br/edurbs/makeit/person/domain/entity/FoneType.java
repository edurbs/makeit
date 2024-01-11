package br.edurbs.makeit.person.domain.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class FoneType {
    String id;

    @NotBlank
    String description;
}
