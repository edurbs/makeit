package br.edurbs.makeit.person.domain.person.address;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import br.edurbs.makeit.person.domain.exception.DomainEntityValidationException;

class ZipCodeTest {

	String validZipCodeWithMask = "12.345-678";
	String validZipCodeWithoutMask = "12345678";

	@ParameterizedTest
	@ValueSource(strings = {"12345678", "37010070", "11123456"})
	void givenValidZipCodeWithoutMask_whenCreate_thenShouldNotThrowException() {
		assertDoesNotThrow(() -> new ZipCode(validZipCodeWithoutMask));
	}

	@ParameterizedTest
	@ValueSource(strings = {"12.345-678", "37010-070", "11-123-456"})
	void givenValidZipCodeWithMask_whenCreate_thenShouldNotThrowException() {
		assertDoesNotThrow(() -> new ZipCode(validZipCodeWithMask));
	}

	@ParameterizedTest
	@ValueSource(strings = {"0", "123", "122.345-678", "372010-070", "11-1223-456"})
	void givenInvaliZipCode_whenCreate_thenThrows() {
		assertThrows(DomainEntityValidationException.class, () -> new ZipCode("some number"));
	}
}
