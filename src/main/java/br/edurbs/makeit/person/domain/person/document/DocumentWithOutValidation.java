package br.edurbs.makeit.person.domain.person.document;

public class DocumentWithOutValidation implements DocumentValidator {

	@Override
	public boolean isValid(String value) {
		return true;
	}

	@Override
	public String getMessage() {
		return "";
	}

}
