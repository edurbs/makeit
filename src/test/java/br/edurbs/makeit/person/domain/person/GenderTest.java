package br.edurbs.makeit.person.domain.person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class GenderTest {
    @Test
    void getName_returnsCorrectValue() {
        Gender male = Gender.MALE;

        assertEquals("Masculino", male.getDescription());
    }
}
