package br.edurbs.makeit.person.domain.entity.maindocument;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import br.edurbs.makeit.person.domain.entity.exception.DomainEntityValidationException;
import br.edurbs.makeit.person.domain.entity.exception.InvalidCnpjException;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CnpjIT {

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
