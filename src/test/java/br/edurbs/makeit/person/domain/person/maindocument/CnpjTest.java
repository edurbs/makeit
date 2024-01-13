package br.edurbs.makeit.person.domain.person.maindocument;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import br.edurbs.makeit.person.domain.person.exception.DomainEntityValidationException;
import br.edurbs.makeit.person.domain.person.exception.InvalidCnpjException;

class CnpjTest {

    String validNumberWithMask = "10.987.054/0001-46";
    String validNumber = "10987054000146";

    @Test
    void givenCnpj_whenCreate_thenGetSameCnpj() {
        var cnpj = new Cnpj(validNumber);
        assertEquals(validNumber, cnpj.value());
    }

    @Test
    void givenCnpjWithdots_whenCreate_thenGetSameCnpjWithoutDots() {
        var cnpj = new Cnpj(validNumberWithMask);
        assertEquals(validNumber, cnpj.value());
    }

    @Test
    void givenBlankNumber_whenCreateCnpj_thenThrows() {
        var blankNumber = "";
        assertThrows(DomainEntityValidationException.class,
                () -> new Cnpj(blankNumber));
    }

    @Test
    void givenInvalidNumber_whenCreateCnpj_thenThrows() {
        var invalidNumber = "10.987.054/0001-45";
        assertThrows(DomainEntityValidationException.class,
                () -> new Cnpj(invalidNumber));
    }

    @Test
    void givenValidNumber_whenCreateCnpj_thenNotThrows() throws InvalidCnpjException {
        var cnpj = new Cnpj(validNumber);
        assertDoesNotThrow(() -> cnpj.validate());
    }

    @Test
    void testEqualsAndHashCode() {
        Cnpj cnpj1 = new Cnpj(validNumber);
        Cnpj cnpj2 = new Cnpj(validNumber);

        assertTrue(cnpj1.equals(cnpj2));
        assertEquals(cnpj1.hashCode(), cnpj2.hashCode());
        assertNotNull(cnpj1.toString());
    }
}
