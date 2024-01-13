package br.edurbs.makeit.person.domain.person;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import br.edurbs.makeit.person.domain.person.address.Address;
import br.edurbs.makeit.person.domain.person.document.Document;
import br.edurbs.makeit.person.domain.person.maindocument.MainDocument;
import jakarta.validation.Validation;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class Person {

    String id;

    OffsetDateTime createdAt;
    OffsetDateTime updatedAt;

    @lombok.NonNull
    PersonType personType;

    @lombok.NonNull
    @NotBlank
    @Size(min = 3)
    String name;

    String nickname;

    MainDocument mainDocument;

    @Getter(AccessLevel.NONE)
    Set<Document> documents = new HashSet<>();

    @Past
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
    Set<EmailAddress> emails = new HashSet<>();


    public Set<Document> getDocuments() {
        return Collections.unmodifiableSet(documents);
    }

    public Set<Address> getAddresses() {
        return Set.copyOf(addresses);
    }

    public Set<Phone> getPhones() {
        return Set.copyOf(phones);
    }

    public Set<EmailAddress> getEmails() {
        return Set.copyOf(emails);
    }

    public boolean isValid() {
        var factory = Validation.buildDefaultValidatorFactory();
        var validator = factory.getValidator();
        return validator.validate(this).isEmpty();
    }
}
