package br.edurbs.makeit.person.domain.person.document;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PassaporteValidator implements DocumentValidator {

	@Override
	public boolean isValid(String value) {
		Pattern pattern = Pattern.compile("\\[A-Z]{2}\\d{6}");
		Matcher matcher = pattern.matcher(value);
		return matcher.find();
	}

	@Override
	public String getMessage() {
		return "Passaporte inválido";
	}

}
