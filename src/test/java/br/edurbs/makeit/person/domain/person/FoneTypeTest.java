package br.edurbs.makeit.person.domain.person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import br.edurbs.makeit.person.domain.person.exception.DomainEntityValidationException;

class FoneTypeTest {

    @Test
    void givenBlankValue_whenCreatingFoneType_thenThrowsException() {
        assertThrows(DomainEntityValidationException.class, () -> new FoneType(""));
    }

    @Test
    void getValue_returnsCorrectValue() {
        FoneType type = new FoneType("Home");

        assertEquals("Home", type.value());
    }

}
