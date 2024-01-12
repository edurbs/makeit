package br.edurbs.makeit.person.domain.person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import br.edurbs.makeit.person.domain.person.PersonType;

 class PersonTypeTest {

    @Test
     void testFisica() {
        PersonType personType = PersonType.FISICA;
        assertEquals("FISICA", personType.name());
    }

    @Test
     void testJuridica() {
        PersonType personType = PersonType.JURIDICA;
        assertEquals("JURIDICA", personType.name());
    }
}