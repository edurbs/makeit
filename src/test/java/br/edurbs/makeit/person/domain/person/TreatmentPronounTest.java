package br.edurbs.makeit.person.domain.person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

class TreatmentPronounTest {
    @Test
    void getPronounAbbreviation_returnsCorrectValue() {
        assertEquals("Sr", TreatmentPronoun.SENHOR.getPronounAbbreviation());
    }

    @Test
    void getPronoun_returnsCorrectValue() {
        assertEquals("Senhor", TreatmentPronoun.SENHOR.getPronoun());
    }

    @Test
    void values_haveDefinedOptions() {
        assertTrue(Arrays.asList(TreatmentPronoun.values()).contains(TreatmentPronoun.SENHOR));
    }

}
