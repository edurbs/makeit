package br.edurbs.makeit.person.domain.person;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PersonType {
    FISICA("Física"),
	JURIDICA("Jurídica");

	private final String description;
}
