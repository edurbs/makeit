package br.edurbs.makeit.person.domain.entity.maindocument;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.lang.NonNull;
import br.edurbs.makeit.person.application.usecase.validation.DefafultValidatorService;
import br.edurbs.makeit.person.domain.entity.exception.InvalidCnpjException;
import br.edurbs.makeit.person.domain.validation.ValidatorService;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CnpjIT {

    @NonNull static ValidatorService validatorService = new DefafultValidatorService();

    @NonNull String invalidNumber = "10.987.054/0001-45";
    @NonNull String validNumber = "10.987.054/0001-46";

    @BeforeAll
    static void setup() {
        validatorService = new DefafultValidatorService();
    }

    @Test
    void givenInvalidNumber_whenCreateCnpj_thenThrows() {
        assertThrows(InvalidCnpjException.class,
                () -> new Cnpj(invalidNumber, validatorService));
    }

    @Test
    void givenInvalidNumber_whenSetCnpj_thenThrows() throws InvalidCnpjException {
        Cnpj cnpj = new Cnpj(validNumber, validatorService);
        assertThrows(InvalidCnpjException.class,
                () -> cnpj.setNumber(invalidNumber));
        assertEquals(validNumber.replaceAll("\\D+", ""), cnpj.getNumber());
    }

    @Test
    void givenValidNumber_whenCreateCnpj_thenNotThrows() throws InvalidCnpjException {
        assertDoesNotThrow(() -> new Cnpj(validNumber, validatorService));
    }

    @Test
    void givenValidNumber_whenSettingCnpj_thenNotThrows() throws InvalidCnpjException {
        Cnpj cnpj = new Cnpj(validNumber, validatorService);
        String newValidCnpj = "18082835000101";
        assertDoesNotThrow(() -> cnpj.setNumber(newValidCnpj));
        assertEquals(newValidCnpj, cnpj.getNumber());
    }


}
