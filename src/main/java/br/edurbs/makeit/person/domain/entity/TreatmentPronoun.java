package br.edurbs.makeit.person.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TreatmentPronoun {
    SENHOR("Sr", "Senhor"),
    SENHORA("Sra", "Senhora"),
    SENHORITA("Srta", "Senhorita"),
    NONE("","");

    private final String pronounAbbreviation;
    private final String pronoun;

}
