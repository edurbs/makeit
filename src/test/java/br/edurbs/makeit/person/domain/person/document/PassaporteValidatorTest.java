package br.edurbs.makeit.person.domain.person.document;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class PassaporteValidatorTest {

	@Test
	void givevInvalidPassaporte_whenIsValid_thenReturnFalse() {
		assertFalse(new PassaporteValidator().isValid("123"));
	}

	@Test
	void givenValidPassport_whenIsValid_thenReturnTrue() {
		assertTrue(new PassaporteValidator().isValid("CS265436"));
	}

	@Test
	void given_whenGetMessage_thenReturnsMessage() {
		assertEquals("Passaporte inválido", new PassaporteValidator().getMessage());
	}
}
