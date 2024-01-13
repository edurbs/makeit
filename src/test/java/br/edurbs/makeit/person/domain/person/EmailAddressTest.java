package br.edurbs.makeit.person.domain.person;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.lang.reflect.Modifier;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import br.edurbs.makeit.person.domain.person.exception.DomainEntityValidationException;

@ExtendWith(MockitoExtension.class)
class EmailAddressTest {

    String id = "1";

    @Mock
    EmailType emailType;

    @Mock
    Email email;

    @Test
    void classMustBeNotFinal() {
        assertFalse(Modifier.isFinal(EmailAddress.class.getModifiers()));
    }

    @Test
    void givenValidEmail_whenCreateEmail_thenNotThrows() {
        assertDoesNotThrow(() -> new EmailAddress(id, emailType, email));
    }

    @Test
    void givenInvalidId_whenCreateEmail_thenThrows() {
        assertThrows(DomainEntityValidationException.class,
                () -> new EmailAddress("", emailType, email));
        assertThrows(DomainEntityValidationException.class, () -> new EmailAddress(null, emailType, email));
    }

    @Test
    void givenInvalidEmailType_whenCreateEmail_thenThrows() {
        assertThrows(DomainEntityValidationException.class,
                () -> new EmailAddress(id, null, email));
    }

    @Test
    void givenInvalidEmail_whenCreateEmail_thenThrows() {
        assertThrows(DomainEntityValidationException.class,
                () -> new EmailAddress(id, emailType, null));
    }



}
