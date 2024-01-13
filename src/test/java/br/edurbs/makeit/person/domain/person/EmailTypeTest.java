package br.edurbs.makeit.person.domain.person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import br.edurbs.makeit.person.domain.person.exception.DomainEntityValidationException;

public class EmailTypeTest {
    @Test
    void givenBlankValue_whenCreatingEmailType_thenThrowsException() {
        assertThrows(DomainEntityValidationException.class, () -> new EmailType(""));
    }

    @Test
    void getValue_returnsCorrectValue() {
        EmailType type = new EmailType("Personal");
        assertNotNull(type);
        assertEquals("Personal", type.value());
    }

}
