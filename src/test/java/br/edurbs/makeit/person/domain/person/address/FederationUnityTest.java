package br.edurbs.makeit.person.domain.person.address;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import br.edurbs.makeit.person.domain.exception.DomainEntityValidationException;

@ExtendWith(MockitoExtension.class)
class FederationUnityTest {

	@Mock
	private Country country;

	@Test
	void givenValidFederationUnity_whenCreate_thenDoesNotThrows() {
		assertDoesNotThrow( () -> new FederationUnity("1", "some acronym", "some name", country));
	}

	@Test
	void givenBlankId_whenCreate_thenThrows() {
		assertThrows(DomainEntityValidationException.class,
				() -> new FederationUnity("", "some acronym", "some name", country));
		assertThrows(DomainEntityValidationException.class,
				() -> new FederationUnity(null, "some acronym", "some name", country));
	}

	@Test
	void givenBlankAcronym_whenCreate_thenThrows() {
		assertThrows(DomainEntityValidationException.class,
				() -> new FederationUnity("1", "", "some name", country));
		assertThrows(DomainEntityValidationException.class,
				() -> new FederationUnity("1", null, "some name", country));
	}

	@Test
	void givenBlankName_whenCreate_thenThrows() {
		assertThrows(DomainEntityValidationException.class,
				() -> new FederationUnity("1", "some acronym", "", country));
		assertThrows(DomainEntityValidationException.class,
				() -> new FederationUnity("1", "some acronym", null, country));
	}

	@Test
	void givenNullCountry_whenCreate_thenThrows() {
		assertThrows(DomainEntityValidationException.class,
				() -> new FederationUnity("1", "some acronym", "some name", null));
	}


}
