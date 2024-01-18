package br.edurbs.makeit.person.domain.person.address;

import br.edurbs.makeit.person.domain.DomainEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record City(
		@NotBlank String id,
		@NotBlank String name,
		@NotNull FederationUnity federationUnity,
		@NotNull Country country) implements DomainEntity {

	public City(String id, String name, FederationUnity federationUnity, Country country) {
		this.id = id;
		this.name = name;
		this.federationUnity = federationUnity;
		this.country = country;
		this.validate();
	}
}
