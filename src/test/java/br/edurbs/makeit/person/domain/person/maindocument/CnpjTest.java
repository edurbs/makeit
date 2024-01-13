package br.edurbs.makeit.person.domain.person.maindocument;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import br.edurbs.makeit.person.domain.person.exception.DomainEntityValidationException;
import br.edurbs.makeit.person.domain.person.exception.InvalidCnpjException;

class CnpjTest {
    @Test
    void givenCnpj_whenCreate_thenGetSameCnpj() {
        String number = "1234567890";
        var cnpj = new Cnpj(number);
        assertEquals(number, cnpj.getNumber());
    }

    @Test
    void givenCnpjWithdots_whenCreate_thenGetSameCnpjWithoutDots() {
        var cnpj = new Cnpj("12.345.678/9012-34");
        assertEquals("12345678901234", cnpj.getNumber());
    }

    @Test
    void givenBlankNumber_whenCreateCnpj_thenThrows() {
        var invalidNumber = "";
        var cnpj = new Cnpj(invalidNumber);
        assertThrows(DomainEntityValidationException.class,
                () -> cnpj.validate());
    }

    @Test
    void givenInvalidNumber_whenCreateCnpj_thenThrows() {
        var invalidNumber = "10.987.054/0001-45";
        var cnpj = new Cnpj(invalidNumber);
        assertThrows(DomainEntityValidationException.class,
                () -> cnpj.validate());
    }

    @Test
    void givenValidNumber_whenCreateCnpj_thenNotThrows() throws InvalidCnpjException {
        var validNumber = "10.987.054/0001-46";
        var cnpj = new Cnpj(validNumber);
        assertDoesNotThrow(() -> cnpj.validate());
    }
}
