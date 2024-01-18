package br.edurbs.makeit.person.domain.person.document;

public interface DocumentValidator {
	boolean isValid(String value);

	String getMessage();
}
