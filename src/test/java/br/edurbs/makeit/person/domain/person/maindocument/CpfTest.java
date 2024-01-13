package br.edurbs.makeit.person.domain.person.maindocument;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import br.edurbs.makeit.person.domain.person.exception.DomainEntityValidationException;
import br.edurbs.makeit.person.domain.person.exception.InvalidCpfException;

class CpfTest {
    @Test
    void givenCpf_whenCreate_thenGetSameCpf() {
        String number = "20763426059";
        var Cpf = new Cpf(number);
        assertEquals(number, Cpf.getNumber());
    }

    @Test
    void givenCpfWithdots_whenCreate_thenGetSameCpfWithoutDots() {
        var Cpf = new Cpf("324.818.410-85");
        assertEquals("32481841085", Cpf.getNumber());
    }

    @Test
    void givenBlankNumber_whenCreateCpf_thenThrows() {
        var invalidNumber = "";
        var Cpf = new Cpf(invalidNumber);
        assertThrows(DomainEntityValidationException.class,
                () -> Cpf.validate());
    }

    @Test
    void givenInvalidNumber_whenCreateCpf_thenThrows() {
        var invalidNumber = "324.818.410-86";
        var Cpf = new Cpf(invalidNumber);
        assertThrows(DomainEntityValidationException.class,
                () -> Cpf.validate());
    }

    @Test
    void givenValidNumber_whenCreateCpf_thenNotThrows() throws InvalidCpfException {
        var validNumber = "324.818.410-85";
        var Cpf = new Cpf(validNumber);
        assertDoesNotThrow(() -> Cpf.validate());
    }
}
