package br.edurbs.makeit.person.domain.person.document;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum DocumentType {
    CNH("Carteira Nacional de Habilitação"),
    RG("Registro Geral"),
    PASSAPORTE("Passaporte"),
    TITULO_ELEITORAL("Titulo Eleitoral"),
    IE("Inscricão Estadual"),
	IM("Inscricão Municipal"),
	OUTRO("Outro");

    private final String name;


}
