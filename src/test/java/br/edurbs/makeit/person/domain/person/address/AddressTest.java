package br.edurbs.makeit.person.domain.person.address;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import br.edurbs.makeit.person.domain.exception.DomainEntityValidationException;

@ExtendWith(MockitoExtension.class)
class AddressTest {

	@Mock
	City city;

	@Mock
	ZipCode zipCode;

	@Mock
	Country country;

	Address address;

	@BeforeEach
	void setUp() {
		this.address = new Address("id", "some address");
	}

	@Test
	void givenSameId_whenEquals_returnTrue() {
		var address = new Address("id", "other address");
		assertEquals(this.address, address);
		assertEquals(this.address.hashCode(), address.hashCode());
	}

	@Test
	void givenValidAddress_whenCreate_thenDoesNotThrows() {
		assertDoesNotThrow(() -> new Address("id","some address"));
	}

	@Test
	void givenInvalidId_whenCreate_thenThrows() {
		assertThrows(DomainEntityValidationException.class,
				() -> new Address(null, "some address"));
		assertThrows(DomainEntityValidationException.class, () -> new Address("", "some address"));
	}

	@Test
	void givenInvalidId_whenSet_thenThrows() {
		var address = new Address("id", "some address");
		assertThrows(DomainEntityValidationException.class,
				() -> address.setId(null));
		assertThrows(DomainEntityValidationException.class,
				() -> address.setId(""));
	}

	@Test
	void givenInvalidStreet_whenCreate_thenTHrows() {
		assertThrows(DomainEntityValidationException.class, () -> new Address("id", null));
		assertThrows(DomainEntityValidationException.class, () -> new Address("id", ""));
	}

	@Test
	void givenInvalidStreet_whenSet_thenThrows() {
		var address = new Address("id", "some address");
		assertThrows(DomainEntityValidationException.class,
				() -> address.setStreet(null));
		assertThrows(DomainEntityValidationException.class,
				() -> address.setStreet(""));
	}

	@Test
	void givenNumber_whenSet_thenGetTheSame() {
		address.setNumber("123");
		assertEquals("123", address.getNumber());
	}

	@Test
	void givenComplement_whenSet_thenGetTheSame() {
		address.setComplement("some complement");
		assertEquals("some complement", address.getComplement());
	}

	@Test
	void givenNeighborhood_whenSet_thenGetTheSame() {
		address.setNeighborhood("some neighborhood");
		assertEquals("some neighborhood", address.getNeighborhood());
	}

	@Test
	void givenZipCode_whenSet_thenGetTheSame() {
		address.setZipCode(zipCode);
		assertEquals(zipCode, address.getZipCode());
	}

	@Test
	void givenCity_whenSet_thenGetTheSame() {
		address.setCity(city);
		assertEquals(city, address.getCity());
	}

	@Test
	void givenCountry_whenSet_thenGetTheSame() {
		address.setCountry(country);
		assertEquals(country, address.getCountry());
	}

	@Test
	void givenStreet_whenSet_thenGetTheSame() {
		address.setStreet("some street");
		assertEquals("some street", address.getStreet());
	}

	@Test
	void givenId_whenSet_thenGetSameId() {
		var id = "1";
		address.setId(id);
		assertEquals(id, address.getId());
	}

}
