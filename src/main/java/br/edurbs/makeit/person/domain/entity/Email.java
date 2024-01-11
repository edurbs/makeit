package br.edurbs.makeit.person.domain.entity;

import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class Email {
    @Nonnull
    EmailType emailType;

    @NotBlank
    @jakarta.validation.constraints.Email
    String address;

}
