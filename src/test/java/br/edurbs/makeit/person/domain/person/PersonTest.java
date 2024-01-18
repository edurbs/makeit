package br.edurbs.makeit.person.domain.person;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import br.edurbs.makeit.person.domain.exception.DomainEntityValidationException;
import br.edurbs.makeit.person.domain.person.address.Address;
import br.edurbs.makeit.person.domain.person.document.Document;
import br.edurbs.makeit.person.domain.person.maindocument.Cpf;
import br.edurbs.makeit.person.domain.person.maindocument.MainDocument;

@ExtendWith(MockitoExtension.class)
class PersonTest {

    Person person;

    @BeforeEach
    void createValidPerson() {
		person = new Person("1", PersonType.FISICA, "Some Name");
    }


    @Test
    void givenValidPerson_whenCreate_thenDoesNotThrows() {
		assertDoesNotThrow(() -> createValidPerson());
    }

    @Test
    void givenId_whenSet_thenGetSameId() {
        var id = "1";
        person.setId(id);
        assertEquals(id, person.getId());
    }

    @Test
    void givenCreateDateTime_whenSet_thenGetSameCreateDateTime() {
        OffsetDateTime dateTime = OffsetDateTime.parse("2024-01-11T13:42+03:00");
        person.setCreatedAt(dateTime);
        assertEquals(dateTime, person.getCreatedAt());
    }

    @Test
    void givenUpdateDateTime_whenSet_thenGetSameUpdateDateTime() {
        OffsetDateTime dateTime = OffsetDateTime.parse("2024-01-11T13:42+03:00");
        person.setUpdatedAt(dateTime);
        assertEquals(dateTime, person.getUpdatedAt());
    }

    @Test
    void givenPersonType_whenSet_thenGetSamePersonType() {
        person.setPersonType(PersonType.FISICA);
        assertEquals(PersonType.FISICA, person.getPersonType());

        person.setPersonType(PersonType.JURIDICA);
        assertEquals(PersonType.JURIDICA, person.getPersonType());
    }

    @Test
    void givenNullPersonType_whenCreate_thenThrows() {
        assertThrows(DomainEntityValidationException.class, () -> new Person("1",null, "Some Name"));
    }

    @Test
    void givenNullPersonType_whenSet_thenThrows() {
        assertThrows(DomainEntityValidationException.class,
                () -> person.setPersonType(null));
    }

    @Test
    void givenName_whenSet_thenGetSameName() {
        person.setName("Some Name");
        assertEquals("Some Name", person.getName());
    }

    @Test
    void givenNullName_whenCreate_thenThrows() {
        assertThrows(DomainEntityValidationException.class,
                () -> new Person("1", PersonType.FISICA, null));
    }

    @Test
	void givenBlankName_whenCreate_thenThrows() {
		assertThrows(DomainEntityValidationException.class,
                () -> new Person("1", PersonType.FISICA, ""));
    }

    @Test
    void givenBlankName_whenSet_thenIsNotValid() {
        var validPerson = new Person("1", PersonType.FISICA, "Valid Name");
        assertThrows(DomainEntityValidationException.class, () ->  validPerson.setName(""));
    }

    @Test
    void givenNameWithLessThan3Characters_whenCreate_thenThrows() {
		assertThrows(DomainEntityValidationException.class, () ->new Person("1", PersonType.FISICA, "a"));
    }

    @Test
    void givenNullName_whenSet_thenThrows() {
        var validPerson = new Person("1", PersonType.FISICA, "Some valid name");
        assertThrows(DomainEntityValidationException.class,
                () -> validPerson.setName(null));
    }

    @Test
    void givenNickname_whenSet_thenGetSameNickname() {
        person.setNickname("Some Nickname");
        assertEquals("Some Nickname", person.getNickname());
    }

    @Test
    void givenMainDocument_whenSet_thenGetSameMainDocument() {
        MainDocument mockDocument = mock(Cpf.class);
        person.setMainDocument(mockDocument);
        assertEquals(mockDocument, person.getMainDocument());
    }

    @Test
    void givenDocuments_whenSet_thenGetSameDocuments() {
        var documents = Set.of(mock(Document.class), mock(Document.class));
        person.setDocuments(documents);
        assertEquals(documents, person.getDocuments());
    }

    @Test
    void givenBirthDate_whenSet_thenGetSameBirthDate() {
        var birthDate = LocalDate.now().minusDays(1);
        person.setBirthDate(birthDate);
        assertEquals(birthDate, person.getBirthDate());
    }

    @Test
	void givenInvalidBirthDate_whenSet_thenThrows() {
		LocalDate plusDays = LocalDate.now().plusDays(1);
		assertThrows(DomainEntityValidationException.class,
				() -> person.setBirthDate(plusDays));
    }

    @Test
    void givenNote_whenSet_thenGetSameNote() {
        person.setNote("Some Note");
        assertEquals("Some Note", person.getNote());
    }

    @Test
    void givenActive_whenSet_thenGetSameActive() {
        person.setActive(true);
        assertTrue(person.isActive());
    }

    @Test
    void givenTreatmentPronoun_whenSet_thenGetSameTreatmentPronoun() {
        person.setTreatmentPronoun(TreatmentPronoun.SENHOR);
        assertEquals(TreatmentPronoun.SENHOR, person.getTreatmentPronoun());
    }

    @Test
    void givenGender_whenSet_thenGetSameGender() {
        person.setGender(Gender.MALE);
        assertEquals(Gender.MALE, person.getGender());
    }

    @Test
    void givenAddresses_whenSet_thenGetSameAddresses() {
        var addresses = Set.of(mock(Address.class), mock(Address.class));
        person.setAddresses(addresses);
        assertEquals(addresses, person.getAddresses());
    }

    @Test
    void givenPhones_whenSet_thenGetSamePhones() {
        var phones = Set.of(mock(Phone.class), mock(Phone.class));
        person.setPhones(phones);
        assertEquals(phones, person.getPhones());
    }

    @Test
    void givenEmails_whenSet_thenGetSameEmails() {
        var emails = Set.of(mock(Email.class), mock(Email.class));
        person.setEmails(emails);
        assertEquals(emails, person.getEmails());
    }
}
