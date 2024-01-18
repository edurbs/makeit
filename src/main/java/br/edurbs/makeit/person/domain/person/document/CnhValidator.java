package br.edurbs.makeit.person.domain.person.document;

public class CnhValidator implements DocumentValidator {

	// based on https://gist.github.com/felipecwb/f32f70bf05bdf1ec5663
	@Override
	public boolean isValid(String value) {
		if (value == null) {
			return true;
		}
		if (value.length() != 11 || !value.matches("\\d+")) {
			return false;
		}
		if (value.chars()
				.filter(Character::isDigit)
				.distinct().count() == 1) {
			return false;
		}

		long sum = 0;
		long mult = 9;

		for (int i = 0; i < 9; ++i, --mult) {
			sum += ((value.charAt(i) - 48) * mult);
		}

		long dsc = 0;
		long digit1 = sum % 11;

		if (digit1 >= 10) {
			digit1 = 0;
			dsc = 2;
		}

		sum = 0;
		mult = 1;

		for (int i = 0; i < 9; ++i, ++mult) {
			sum += ((value.charAt(i) - 48) * mult);
		}

		long mod = sum % 11;
		long digit2 = (mod >= 10) ? 0 : mod - dsc;

		return (String.valueOf(digit1) + String.valueOf(digit2))
				.equals(value.substring(value.length() - 2));

	}

	@Override
	public String getMessage() {
		return "CNH inválida";
	}

}
