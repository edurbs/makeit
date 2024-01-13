package br.edurbs.makeit.person.domain.person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import br.edurbs.makeit.person.domain.person.exception.DomainEntityValidationException;

class EmailTest {

    @Test
    void givenBlankValue_whenCreatingEmail_thenThrowsException() {
        assertThrows(DomainEntityValidationException.class, () -> new Email(""));
    }

    @Test
    void givenInvalidValue_whenCreatingEmail_thenThrowsException() {
        assertThrows(DomainEntityValidationException.class, () -> new Email("asd@..asd.com"));
    }

    @Test
    void getValue_returnsCorrectValue() {
        Email email = new Email("test@email.com");

        assertEquals("test@email.com", email.value());
    }

    @Test
    void createValidEmail_returnsEmail() {
        Email email = new Email("test@email.com");

        assertNotNull(email);
    }


}
