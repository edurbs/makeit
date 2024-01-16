package br.edurbs.makeit.person.domain.person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import br.edurbs.makeit.person.domain.exception.DomainEntityValidationException;

class EmailAddressTest {

    @Test
    void givenBlankValue_whenCreatingEmail_thenThrowsException() {
        assertThrows(DomainEntityValidationException.class, () -> new EmailAddress(""));
    }

    @Test
    void givenInvalidValue_whenCreatingEmail_thenThrowsException() {
        assertThrows(DomainEntityValidationException.class, () -> new EmailAddress("asd@..asd.com"));
    }

    @Test
    void givenNullValue_whenCreatingEmail_thenThrowsException() {
        assertThrows(DomainEntityValidationException.class, () -> new EmailAddress(null));
    }

    @Test
    void getValue_returnsCorrectValue() {
        EmailAddress email = new EmailAddress("test@email.com");

        assertNotNull(email);
        assertEquals("test@email.com", email.value());
    }



}
