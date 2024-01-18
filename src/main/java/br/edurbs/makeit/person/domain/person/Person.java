package br.edurbs.makeit.person.domain.person;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import br.edurbs.makeit.person.domain.DomainEntity;
import br.edurbs.makeit.person.domain.person.address.Address;
import br.edurbs.makeit.person.domain.person.document.Document;
import br.edurbs.makeit.person.domain.person.maindocument.MainDocument;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;


@Data
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class Person implements DomainEntity {

	@NotBlank
	@Setter(AccessLevel.NONE)
    String id;

	@NotNull
	@Setter(AccessLevel.NONE)
	PersonType personType;

    @NotBlank
	@Size(min = 3)
	@Setter(AccessLevel.NONE)
    String name;

	OffsetDateTime createdAt;
    OffsetDateTime updatedAt;
    String nickname;
    MainDocument mainDocument;

    @Getter(AccessLevel.NONE)
    Set<Document> documents = new HashSet<>();

	@Past
	@Setter(AccessLevel.NONE)
    LocalDate birthDate;

    String note;
    boolean active;
	TreatmentPronoun treatmentPronoun = TreatmentPronoun.NONE;
    Gender gender = Gender.NONE;

    @Getter(AccessLevel.NONE)
    Set<Address> addresses = new HashSet<>();

    @Getter(AccessLevel.NONE)
    Set<Phone> phones  = new HashSet<>();

    @Getter(AccessLevel.NONE)
    Set<Email> emails = new HashSet<>();

	public Person(String id, PersonType personType, String name) {
		this.id = id;
		this.personType = personType;
		this.name = name;
		this.validate();
	}

	public void setPersonType(PersonType personType){
		this.personType = personType;
		this.validate();
	}

	public void setId(String id){
		this.id = id;
		this.validate();
	}

	public void setName(String name){
		this.name = name;
		this.validate();
	}

	public void setBirthDate(LocalDate birthDate){
		this.birthDate = birthDate;
		this.validate();
	}

    public Set<Document> getDocuments() {
        return Collections.unmodifiableSet(documents);
    }

    public Set<Address> getAddresses() {
        return Set.copyOf(addresses);
    }

    public Set<Phone> getPhones() {
        return Set.copyOf(phones);
    }

    public Set<Email> getEmails() {
        return Set.copyOf(emails);
    }

}
