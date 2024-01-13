package br.edurbs.makeit.person.domain.person;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.lang.reflect.Modifier;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import br.edurbs.makeit.person.domain.person.exception.DomainEntityValidationException;

@ExtendWith(MockitoExtension.class)
class EmailAddressTest {

    String validEmail = "someValue@someValue.com";
    String id = "1";

    @Mock
    EmailType emailType;

    @Test
    void classMustBeFinal() {
        assertTrue(Modifier.isFinal(EmailAddress.class.getModifiers()));
    }

    @Test
    void givenValidEmail_whenCreateEmail_thenNotThrows() {
        assertDoesNotThrow(() -> new EmailAddress(id, emailType, validEmail));
    }

    @Test
    void givenBlankId_whenCreateEmail_thenThrows() {
        assertThrows(DomainEntityValidationException.class, () -> new EmailAddress("", emailType, validEmail));
    }

    @Test
    void givenNullEmailType_whenCreateEmail_thenThrows() {
        assertThrows(DomainEntityValidationException.class,
                () -> new EmailAddress(id, null, validEmail));
    }

    @Test
    void givenBlankEmail_whenCreateEmail_thenThrows() {
        assertThrows(DomainEntityValidationException.class, () -> new EmailAddress(id, emailType, ""));
    }

    @Test
    void givenInvalidEmail_whenCreateEmail_thenThrows() {
        assertThrows(DomainEntityValidationException.class, () -> new EmailAddress(id, emailType, "invalidEmail"));
    }


}
