package br.edurbs.makeit.person.domain.person.maindocument;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import br.edurbs.makeit.person.domain.person.exception.DomainEntityValidationException;
import br.edurbs.makeit.person.domain.person.exception.InvalidCnpjException;

class CnpjTest {

	String validNumberWithMask = "10.987.054/0001-46";
	String validNumber = "10987054000146";

	@Test
	void givenCnpj_whenCreate_thenGetSameCnpj() {
		var cnpj = new Cnpj(validNumber);
		assertEquals(validNumber, cnpj.value());
	}

	@Test
	void givenCnpjWithdots_whenCreate_thenGetSameCnpjWithoutDots() {
		var cnpj = new Cnpj(validNumberWithMask);
		assertEquals(validNumber, cnpj.value());
	}

	@Test
	void givenBlankNumber_whenCreateCnpj_thenThrows() {
		var blankNumber = "";
		assertThrows(DomainEntityValidationException.class, () -> new Cnpj(blankNumber));
	}

	@Test
	void givenBlankNumber_whenCreateCnpj_thenThrowsMessage() {
		var blankNumber = "";
		var exception =
				assertThrows(DomainEntityValidationException.class, () -> new Cnpj(blankNumber));
		assertEquals("Cnpj.value: CNPJ inválido", exception.getMessage());
	}


	@ParameterizedTest
	@ValueSource(strings = {"0", "123", "10987054000145", "10987054000147", "00-000-000/0000-00",
			"00000000000000"})
	void givenInvalidNumber_whenCreateCnpj_thenThrows(String invalidNumber) {
		assertThrows(DomainEntityValidationException.class, () -> new Cnpj(invalidNumber));
	}

	@Test
	void givenValidNumber_whenCreateCnpj_thenNotThrows() throws InvalidCnpjException {
		assertDoesNotThrow(() -> new Cnpj(validNumber));
	}

	@Test
	void testEqualsAndHashCode() {
		Cnpj cnpj1 = new Cnpj(validNumber);
		Cnpj cnpj2 = new Cnpj(validNumber);
		assertEquals(cnpj2, cnpj1);
		assertEquals(cnpj1.hashCode(), cnpj2.hashCode());
		assertNotNull(cnpj1.toString());
	}

	@Test
	void givenCnpjWithouMask_whenGet_thenMask() {
		Cnpj cnpj = new Cnpj(validNumber);
		String mask = cnpj.withMask();
		assertEquals( validNumberWithMask, mask);
	}
}
