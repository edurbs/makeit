package br.edurbs.makeit.person.domain.person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

 class PersonTypeTest {

    @Test
     void testFisica() {
        PersonType personType = PersonType.FISICA;
		assertEquals("FISICA", personType.name());
		assertEquals("Física", personType.getDescription());
    }

    @Test
     void testJuridica() {
        PersonType personType = PersonType.JURIDICA;
		assertEquals("JURIDICA", personType.name());
		assertEquals("Jurídica", personType.getDescription());
    }
}