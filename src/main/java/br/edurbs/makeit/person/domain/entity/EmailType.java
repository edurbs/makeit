package br.edurbs.makeit.person.domain.entity;

import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class EmailType {
    String id;
    String description;
}
