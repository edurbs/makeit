package br.edurbs.makeit.person.domain.entity;

import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class Phone {
    @Nonnull
    FoneType foneType;

    @NotBlank
    String number;

    // TODO validation
}
