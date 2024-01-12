package br.edurbs.makeit.person.domain.entity.maindocument;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import br.edurbs.makeit.person.domain.entity.exception.DomainEntityValidationException;
import br.edurbs.makeit.person.domain.entity.exception.InvalidCnpjException;

@ExtendWith(MockitoExtension.class)
class CnpjTest {

    @Test
    void givenCnpj_whenCreate_thenGetSameCnpj() throws InvalidCnpjException {
        String number = "1234567890";
        var cnpj = new Cnpj(number);
        assertEquals(number, cnpj.getNumber());
    }

    @Test
    void givenCnpjWithdots_whenCreate_thenGetSameCnpjWithoutDots() throws InvalidCnpjException {
        var cnpj = Cnpj.builder().number("12.345.678/9012-34").build();
        assertEquals("12345678901234", cnpj.getNumber());
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
