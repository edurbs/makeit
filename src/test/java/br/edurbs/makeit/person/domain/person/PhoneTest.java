package br.edurbs.makeit.person.domain.person;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import br.edurbs.makeit.person.domain.person.exception.DomainEntityValidationException;
import br.edurbs.makeit.person.domain.validation.MyPhoneValidator;
import br.edurbs.makeit.person.domain.validation.PhoneValidator;

@ExtendWith(MockitoExtension.class)
class PhoneTest {

    @Mock
    PhoneType phoneType;

    PhoneValidator phoneValidator = new MyPhoneValidator();
    //PhoneValidator phoneValidator = new GooglePhoneValidator();

    @ParameterizedTest
    @ValueSource(strings = {"35-3221-1000", "66-98899-8899", "11-2000-0000", "11-3000-0000", "11-4000-0000", "11-5000-9999", "11-7777-8888", "51-7800-0000", "0800 892 5063", "11-4003-4004", "0900-123-4235", "0500 12345 20"})
    void givenValidNumber_whenInstantiate_thenNotThrows(String number) {
        assertDoesNotThrow(() -> new Phone(phoneType, number, phoneValidator));
    }

    @ParameterizedTest
    @ValueSource(strings = {"35-9221-1000", "66-78899-8899", "23-7777-8888", "21-7977-8888", "35-7000-1234", "900-123-1234", "4003-9004", "abc", "0", "1111111111"})
    void givenInvalidNumber_whenInstantiate_thenThrows(String number) {
        assertThrows(DomainEntityValidationException.class, () -> new Phone(phoneType, number, phoneValidator));
    }

    @Test
    void givenNullNumber_whenInstantiate_thenThrows() {
        assertThrows(DomainEntityValidationException.class, () -> new Phone(phoneType, null, phoneValidator));
    }

    @Test
    void givenNullPhoneType_whenInstantiate_thenThrows() {
        assertThrows(DomainEntityValidationException.class, () -> new Phone(null, "35-3221-1000", phoneValidator));
    }

    @Test
    void givenPhoneType_whenGet_thenReturnSamePhoneType() {
        phoneType = new PhoneType("some type");
        Phone phone = new Phone(phoneType, "35-3221-1000", phoneValidator);
        assertEquals(phoneType, phone.phoneType());
    }
}
