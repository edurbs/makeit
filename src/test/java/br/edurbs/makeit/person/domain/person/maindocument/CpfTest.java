package br.edurbs.makeit.person.domain.person.maindocument;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.lang.reflect.Modifier;
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

    @Test
    void classMustBeFinal() {
        assertTrue(Modifier.isFinal(Cpf.class.getModifiers()));
    }

    @Test
    void testEqualsAndHashCode() {
        Cpf cpf1 = new Cpf("value1");
        Cpf cpf2 = new Cpf("value1");

        assertTrue(cpf1.equals(cpf2));
        assertEquals(cpf1.hashCode(), cpf2.hashCode());
        assertNotNull(cpf1.toString());
    }
}
