package br.edurbs.makeit.person.domain.person.maindocument;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.lang.reflect.Modifier;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import br.edurbs.makeit.person.domain.person.exception.DomainEntityValidationException;
import br.edurbs.makeit.person.domain.person.exception.InvalidCpfException;

class CpfTest {
	String validNumberWithMask = "324.818.410-85";
	String validNumber = "32481841085";

	@Test
	void givenCpf_whenCreate_thenGetSameCpf() {
		var Cpf = new Cpf(validNumber);
		assertEquals(validNumber, Cpf.value());
	}

	@Test
	void givenCpfWithMask_whenCreate_thenGetSameCpfWithoutDots() {
		var Cpf = new Cpf(validNumberWithMask);
		assertEquals(validNumber, Cpf.value());
	}

	@Test
	void givenBlankNumber_whenCreateCpf_thenThrows() {
		assertThrows(DomainEntityValidationException.class, () -> new Cpf(""));
	}


	@ParameterizedTest
	@ValueSource(strings = {"0", "123", "324.818.410-86", "32481841086", "11111111111"})
	void givenInvalidNumber_whenCreateCpf_thenThrows(String cpf) {
		assertThrows(DomainEntityValidationException.class, () -> new Cpf(cpf));
	}

	@Test
	void givenValidNumber_whenCreateCpf_thenNotThrows() throws InvalidCpfException {
		assertDoesNotThrow(() -> new Cpf(validNumber));
	}

	@Test
	void givenValidNumberWithMark_whenCreateCpf_thenNotThrows() throws InvalidCpfException {
		assertDoesNotThrow(() -> new Cpf(validNumberWithMask));
	}

	@Test
	void classMustBeFinal() {
		assertTrue(Modifier.isFinal(Cpf.class.getModifiers()));
	}

}
