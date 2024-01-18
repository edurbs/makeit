package br.edurbs.makeit.person.domain.person.address;

import br.edurbs.makeit.person.domain.DomainEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record FederationUnity(
		@NotBlank String id,
		@NotBlank String acronym,
		@NotBlank String name,
		@NotNull Country country) implements DomainEntity{
	public FederationUnity(String id, String acronym, String name, Country country) {
		this.id = id;
		this.acronym = acronym;
		this.name = name;
		this.country = country;
		this.validate();
	}
}
