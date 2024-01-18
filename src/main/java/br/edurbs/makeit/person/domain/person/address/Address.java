package br.edurbs.makeit.person.domain.person.address;

import br.edurbs.makeit.person.domain.DomainEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class Address implements DomainEntity {

	@Include
	@NotBlank
	@Setter(AccessLevel.NONE)
	String id;

    @NotBlank
	@Size(min = 3)
	@Setter(AccessLevel.NONE)
    String street;

    String number;
    String complement;
    String neighborhood;
	City city;
	Country country;
	ZipCode zipCode;

	public Address(String id, String street) {
		this.id = id;
		this.street = street;
		this.validate();
	}

	public void setId(String id) {
		this.id = id;
		this.validate();
	}

	public void setStreet(String street) {
		this.street = street;
		this.validate();
	}


}
