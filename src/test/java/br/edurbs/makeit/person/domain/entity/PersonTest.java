package br.edurbs.makeit.person.domain.entity;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PersonTest {

    Person validPerson;

    @BeforeEach
    void createValidPerson() {
        this.validPerson = new Person(PersonType.FISICA, "Some Name");
    }

    @Test
    void shouldCreatePerson() {
        assertNotNull(validPerson);
    }

    @Test
    void shouldValidatePerson() {
        assertTrue(this.validPerson.isValid());

        var invalidPerson = new Person(PersonType.FISICA, "");
        assertFalse(invalidPerson.isValid());
    }

    @Test
    void shouldThrowExceptionWhenCreatingPersonWithNullPersonType() {
        assertThrows(NullPointerException.class,
                () -> new Person(null, "Some Name"));
    }

    @Test
    void shouldThrowExceptionWhenCreatingPersonWithNullName() {
        assertThrows(NullPointerException.class,
                () -> new Person(PersonType.FISICA, null));
    }

    @Test
    void shouldInvalidateWhenCreatingPersonWithInvalidBirthDate() {
        var person = new Person(PersonType.FISICA, "Some Name");
        person.setBirthDate(LocalDate.now().plusDays(1));
        assertFalse(person.isValid());
    }


}
