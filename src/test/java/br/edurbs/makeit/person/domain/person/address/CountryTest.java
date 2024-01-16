package br.edurbs.makeit.person.domain.person.address;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import br.edurbs.makeit.person.domain.exception.DomainEntityValidationException;

class CountryTest {

	@Test
	void givenNullId_whenCreate_thenThrows() {
		assertThrows(DomainEntityValidationException.class,
				() -> new Country(null, "some country"));
	}

	@Test
	void givenBlankId_whenCreate_thenThrows() {
		assertThrows(DomainEntityValidationException.class, () -> new Country("", "some country"));
	}

	@Test
	void givenNullValue_whenCreate_thenThrows() {
		assertThrows(DomainEntityValidationException.class, () -> new Country("1", null));
	}

	@Test
	void givenBlankValue_whenCreate_thenThrows() {
		assertThrows(DomainEntityValidationException.class, () -> new Country("1", ""));
	}

	@Test
	void givenValidCountry_whenCreate_thenDoesNotThrows() {
		assertDoesNotThrow( () -> new Country("1", "some country"));
	}
}
