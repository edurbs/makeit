package br.edurbs.makeit.person.domain.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import br.edurbs.makeit.person.domain.entity.address.Address;
import br.edurbs.makeit.person.domain.entity.document.Document;
import br.edurbs.makeit.person.domain.entity.maindocument.MainDocument;

class PersonTest {

    Person person;

    @BeforeEach
    void createValidPerson() {
        person = new Person(PersonType.FISICA, "Some Name");
    }

    @Test
    void shouldCreatePerson() {
        assertNotNull(person);
    }

    @Test
    void shouldGetId() {
        var id = "1";
        person.setId(id);
        assertEquals(id, person.getId());
    }

    @Test
    void shouldGetCreatedAt() {
        OffsetDateTime dateTime = OffsetDateTime.parse("2024-01-11T13:42+03:00");
        person.setCreatedAt(dateTime);
        assertEquals(dateTime, person.getCreatedAt());
    }

    @Test
    void shouldGetUpdatedAt() {
        OffsetDateTime dateTime = OffsetDateTime.parse("2024-01-11T13:42+03:00");
        person.setUpdatedAt(dateTime);
        assertEquals(dateTime, person.getUpdatedAt());
    }

    @Test
    void shouldGetPersonType() {
        person.setPersonType(PersonType.FISICA);
        assertEquals(PersonType.FISICA, person.getPersonType());

        person.setPersonType(PersonType.JURIDICA);
        assertEquals(PersonType.JURIDICA, person.getPersonType());
    }

    @Test
    void shouldThrowExceptionWhenCreatingPersonWithNullPersonType() {
        assertThrows(NullPointerException.class,
                () -> new Person(null, "Some Name"));
    }

    @Test
    void shouldGetPersonName() {
        person.setName("Some Name");
        assertEquals("Some Name", person.getName());
    }

    @Test
    void shouldThrowExceptionWhenCreatingPersonWithNullName() {
        assertThrows(NullPointerException.class,
                () -> new Person(PersonType.FISICA, null));
    }

    @Test
    void shouldBeInvalidWhenCreatingPersonWithBlankName() {
        var invalidPerson = new Person(PersonType.FISICA, "");
        assertFalse(invalidPerson.isValid());
    }

    @Test
    void shouldBeInvalidWhenNameIsLessThan3Characters() {
        var invalidPerson = new Person(PersonType.FISICA, "a");
        assertFalse(invalidPerson.isValid());
    }

    @Test
    void shouldGetNickname() {
        person.setNickname("Some Nickname");
        assertEquals("Some Nickname", person.getNickname());
    }

    @Test
    void shouldGetMainDocument() {
        MainDocument mockDocument = mock(MainDocument.class);
        person.setMainDocument(mockDocument);
        assertEquals(mockDocument, person.getMainDocument());
    }

    @Test
    void shouldGetSetOfDocuments() {
        var documents = Set.of(mock(Document.class), mock(Document.class));
        person.setDocuments(documents);
        assertEquals(documents, person.getDocuments());
    }

    @Test
    void shouldGetBirthDate() {
        var birthDate = LocalDate.now();
        person.setBirthDate(birthDate);
        assertEquals(birthDate, person.getBirthDate());
    }

    @Test
    void shouldInvalidateWhenCreatingPersonWithPresenteOrFutureDate() {
        person.setBirthDate(LocalDate.now().plusDays(1));
        assertFalse(person.isValid());
    }

    @Test
    void shouldGetNote() {
        person.setNote("Some Note");
        assertEquals("Some Note", person.getNote());
    }

    @Test
    void shouldGetActive() {
        person.setActive(true);
        assertTrue(person.isActive());
    }

    @Test
    void shouldGetTreatmentPronoun() {
        person.setTreatmentPronoun(TreatmentPronoun.SENHOR);
        assertEquals(TreatmentPronoun.SENHOR, person.getTreatmentPronoun());
    }

    @Test
    void shouldGetGender() {
        person.setGender(Gender.MALE);
        assertEquals(Gender.MALE, person.getGender());
    }

    @Test
    void shouldGetSetOfAddresses() {
        var addresses = Set.of(mock(Address.class), mock(Address.class));
        person.setAddresses(addresses);
        assertEquals(addresses, person.getAddresses());
    }

    @Test
    void shouldGetSetOfPhones() {
        var phones = Set.of(mock(Phone.class), mock(Phone.class));
        person.setPhones(phones);
        assertEquals(phones, person.getPhones());
    }

    @Test
    void shouldGetSetOfEmails() {
        var emails = Set.of(mock(Email.class), mock(Email.class));
        person.setEmails(emails);
        assertEquals(emails, person.getEmails());
    }

    @Test
    void shouldValidatePerson() {
        assertTrue(person.isValid());

        var invalidPerson = new Person(PersonType.FISICA, "");
        assertFalse(invalidPerson.isValid());
    }




}
