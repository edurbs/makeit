package br.edurbs.makeit.person.domain.person.document;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class CnhValidatorTest {

	@Test
	void givenNull_whenIsValid_thenReturnTrue() {
		assertTrue(new CnhValidator().isValid(null));
	}

	@Test
	void givenSmallText_whenIsValid_thenReturnFalse(){
		assertFalse(new CnhValidator().isValid("123"));
	}

	@Test
	void givenLetters_whenIsValid_thenReturnFalse() {
		assertFalse(new CnhValidator().isValid("abc"));
	}

	@Test
	void givenInvalidCnh_whenIsValid_thenReturnFalse() {
		assertFalse(new CnhValidator().isValid("20191017798"));
	}

	@Test
	void givenCnhWithSameNumber_whenIsValid_thenReturnFalse() {
		assertFalse(new CnhValidator().isValid("11111111111"));
	}

	@Test
	void givenValidCnh_whenIsValid_thenReturnTrue() {
		assertTrue(new CnhValidator().isValid("08303031121"));
	}

	@Test
	void given_whenGetMessage_thenReturnMessage() {
		assertEquals("CNH inválida", new CnhValidator().getMessage());
	}

}
