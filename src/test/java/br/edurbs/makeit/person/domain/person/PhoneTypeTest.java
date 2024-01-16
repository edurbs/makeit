package br.edurbs.makeit.person.domain.person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import br.edurbs.makeit.person.domain.exception.DomainEntityValidationException;

class PhoneTypeTest {

    @Test
    void givenBlankValue_whenCreatingFoneType_thenThrowsException() {
        assertThrows(DomainEntityValidationException.class, () -> new PhoneType(""));
    }

    @Test
    void getValue_returnsCorrectValue() {
        PhoneType type = new PhoneType("Home");

        assertEquals("Home", type.value());
    }

}
