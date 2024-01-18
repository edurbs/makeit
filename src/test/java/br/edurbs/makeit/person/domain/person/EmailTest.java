package br.edurbs.makeit.person.domain.person;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.lang.reflect.Modifier;
import org.junit.jupiter.api.Test;
import br.edurbs.makeit.person.domain.exception.DomainEntityValidationException;

class EmailTest {

	String id = "1";

    EmailType emailType = new EmailType("valid");

    EmailAddress email = new EmailAddress("valid@email.com");

	Email validEmail = new Email(id, emailType, email);

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
		assertThrows(DomainEntityValidationException.class,
				() -> new Email(null, emailType, email));

		assertThrows(DomainEntityValidationException.class, () -> validEmail.setId(""));
		assertThrows(DomainEntityValidationException.class, () -> validEmail.setId(null));
    }

    @Test
    void givenInvalidEmailType_whenCreateEmail_thenThrows() {
        assertThrows(DomainEntityValidationException.class,
				() -> new Email(id, null, email));
		assertThrows(DomainEntityValidationException.class, () -> validEmail.setEmailType(null));
    }

    @Test
    void givenInvalidEmail_whenCreateEmail_thenThrows() {
        assertThrows(DomainEntityValidationException.class,
				() -> new Email(id, emailType, null));
		assertThrows(DomainEntityValidationException.class, () -> validEmail.setEmailAddress(null));
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

	@Test
	void givenNotEqualsId_whenCompare_thenReturnFalse() {
		Email newEmailAddress = new Email("2", emailType, email);
		assertNotEquals(validEmail, newEmailAddress);
		assertNotEquals(validEmail.hashCode(), newEmailAddress.hashCode());
	}

}
