package br.edurbs.makeit.person.domain.entity.maindocument;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.lang.NonNull;
import br.edurbs.makeit.person.domain.entity.exception.InvalidCnpjException;
import br.edurbs.makeit.person.domain.validation.ValidatorService;

@ExtendWith(MockitoExtension.class)
class CnpjTest {

    @Mock
    @NonNull ValidatorService mockedValidation;


    void setMockValidationResponse(boolean valid) {
        Mockito.when(mockedValidation.isValid(any())).thenReturn(valid);
    }


    @Test
    void givenCnpj_whenCreate_thenGetSameCnpj() throws InvalidCnpjException {
        setMockValidationResponse(true);
        String number = "1234567890";
        var cnpj = new Cnpj(number, mockedValidation);
        assertEquals(number, cnpj.getNumber());
    }

    @Test
    void givenCnpj_whenSet_thenGetSameCnpj() throws InvalidCnpjException {
        setMockValidationResponse(true);
        var cnpj = new Cnpj("123", mockedValidation);
        String number = "12345678901234";
        cnpj.setNumber(number);
        assertEquals(number, cnpj.getNumber());
    }

    @Test
    void givenCnpjWithdots_whenCreate_thenGetSameCnpjWithoutDots() throws InvalidCnpjException {
        setMockValidationResponse(true);
        var cnpj = new Cnpj("12.345.678/9012-34", mockedValidation);
        assertEquals("12345678901234", cnpj.getNumber());
    }

    @Test
    void givenCnpjWithdots_whenSet_thenGetSameCnpjWithoutDots() throws InvalidCnpjException {
        setMockValidationResponse(true);
        var cnpj = new Cnpj("123", mockedValidation);
        cnpj.setNumber("12.345.678/9012-34");
        assertEquals("12345678901234", cnpj.getNumber());
    }

    @Test
    void givenInvalidCnpj_whenCreate_thenThrows() throws InvalidCnpjException {
        setMockValidationResponse(false);
        assertThrows(InvalidCnpjException.class, () -> new Cnpj("123", mockedValidation));
    }

    @Test
    void givenInvalidCnpj_whenSet_thenThrows() throws InvalidCnpjException {
        setMockValidationResponse(true);
        var cnpj = new Cnpj("123456789", mockedValidation);
        setMockValidationResponse(false);
        assertThrows(InvalidCnpjException.class, () -> cnpj.setNumber("123"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", ""})
    void givenLetterOrBlankCnpj_whenSet_thenThrows(String cnpjValue) {
        setMockValidationResponse(true);
        var cnpj = new Cnpj("123456", mockedValidation);
        assertThrows(InvalidCnpjException.class, () -> cnpj.setNumber(cnpjValue));
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", ""})
    void givenLetterOrBlankCnpj_whenCreate_thenThrows(String cnpjValue) {
        assertThrows(InvalidCnpjException.class, () -> new Cnpj(cnpjValue, mockedValidation));
    }









}
