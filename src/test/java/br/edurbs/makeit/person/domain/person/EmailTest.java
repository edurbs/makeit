package br.edurbs.makeit.person.domain.person;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.lang.reflect.Modifier;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import br.edurbs.makeit.person.domain.exception.DomainEntityValidationException;

@ExtendWith(MockitoExtension.class)
class EmailTest {

    String id = "1";

    @Mock
    EmailType emailType;

    @Mock
    EmailAddress email;

    @Test
    void classMustBeNotFinal() {
        assertFalse(Modifier.isFinal(Email.class.getModifiers()));
    }

    @Test
    void givenValidEmail_whenCreateEmail_thenNotThrows() {
        assertDoesNotThrow(() -> new Email(id, emailType, email));
    }

    @Test
    void givenInvalidId_whenCreateEmail_thenThrows() {
        assertThrows(DomainEntityValidationException.class,
                () -> new Email("", emailType, email));
        assertThrows(DomainEntityValidationException.class, () -> new Email(null, emailType, email));
    }

    @Test
    void givenInvalidEmailType_whenCreateEmail_thenThrows() {
        assertThrows(DomainEntityValidationException.class,
                () -> new Email(id, null, email));
    }

    @Test
    void givenInvalidEmail_whenCreateEmail_thenThrows() {
        assertThrows(DomainEntityValidationException.class,
                () -> new Email(id, emailType, null));
    }

    @Test
    void givenId_whenCreate_thenReturnId() {
        String id = "1";
        Email emailAddress = new Email(id, emailType, email);
        assertEquals(id, emailAddress.getId());
    }

    @Test
    void givenEmailType_whenCreate_thenReturnEmailType() {
        Email emailAddress = new Email(id, emailType, email);
        assertEquals(emailType, emailAddress.getEmailType());
    }

    @Test
    void givenEmail_whenCreate_thenReturnEmail() {
        Email emailAddress = new Email(id, emailType, email);
        assertEquals(email, emailAddress.getEmailAddress());

    }



}
