package br.edurbs.makeit.person.domain.person.document;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class DocumentWithOutValidationTest {

	DocumentWithOutValidation documentWithOutValidation = new DocumentWithOutValidation();

	@Test
	void testGetMessage() {
		assertEquals("", documentWithOutValidation.getMessage());
	}

	@Test
	void testIsValid() {
		assertEquals(true, documentWithOutValidation.isValid(""));
	}
}
