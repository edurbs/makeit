package br.edurbs.makeit.person.domain.person.maindocument;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.lang.reflect.Modifier;
import org.junit.jupiter.api.Test;
import br.edurbs.makeit.person.domain.person.exception.DomainEntityValidationException;
import br.edurbs.makeit.person.domain.person.exception.InvalidCpfException;

class CpfTest {
    String validNumberWithMask = "324.818.410-85";
    String validNumber = "32481841085";

    @Test
    void givenCpf_whenCreate_thenGetSameCpf() {
        var Cpf = new Cpf(validNumber);
        assertEquals(validNumber, Cpf.value());
    }

    @Test
    void givenCpfWithMask_whenCreate_thenGetSameCpfWithoutDots() {
        var Cpf = new Cpf(validNumberWithMask);
        assertEquals(validNumber, Cpf.value());
    }

    @Test
    void givenBlankNumber_whenCreateCpf_thenThrows() {
        assertThrows(DomainEntityValidationException.class,
                () -> new Cpf(""));
    }

    @Test
    void givenInvalidNumber_whenCreateCpf_thenThrows() {
        var invalidNumber = "324.818.410-86";
        assertThrows(DomainEntityValidationException.class,
                () -> new Cpf(invalidNumber));
    }

    @Test
    void givenValidNumber_whenCreateCpf_thenNotThrows() throws InvalidCpfException {
        assertDoesNotThrow(() -> new Cpf(validNumber));
    }

    @Test
    void classMustBeFinal() {
        assertTrue(Modifier.isFinal(Cpf.class.getModifiers()));
    }

}
