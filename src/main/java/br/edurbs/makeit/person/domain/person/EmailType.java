package br.edurbs.makeit.person.domain.person;

import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class EmailType {
    String id;
    String description;
}
