package br.edurbs.makeit.person.domain.person.address;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import br.edurbs.makeit.person.domain.exception.DomainEntityValidationException;

@ExtendWith(MockitoExtension.class)
class CityTest {

	@Mock
	private FederationUnity federationUnity;

	@Mock
	private Country country;

	@Test
	void givenValidCity_whenCreate_thenDoesNotThrows() {
		assertDoesNotThrow(() -> new City("1", "some name", federationUnity, country));
	}

	@Test
	void givenBlankId_whenCreate_thenThrows() {
		assertThrows(DomainEntityValidationException.class,
				() -> new City("", "some name", federationUnity, country));
		assertThrows(DomainEntityValidationException.class,
				() -> new City(null, "some name", federationUnity, country));
	}

	@Test
	void givenBlankName_whenCreate_thenThrows() {
		assertThrows(DomainEntityValidationException.class,
				() -> new City("1", "", federationUnity, country));
		assertThrows(DomainEntityValidationException.class,
				() -> new City("1", null, federationUnity, country));
	}

	@Test
	void givenInvalidFederationUnity_whenCreate_thenThrows() {
		assertThrows(DomainEntityValidationException.class,
				() -> new City("1", "some name", null, country));
	}

	@Test
	void givenInvalidCountry_whenCreate_thenThrows() {
		assertThrows(DomainEntityValidationException.class,
				() -> new City("1", "some name", federationUnity, null));
	}
}
