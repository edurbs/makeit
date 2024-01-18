package br.edurbs.makeit.person.domain.person.document;

public class TituloEleitoralValidator implements DocumentValidator {

	@Override
	public boolean isValid(String value) {

        if (value == null || value.length() != 12 || !value.matches("\\d+")) {
            return false;
        }

        int sum = 0;
        int heigth = 2;

        for (int i = 10; i >= 0; i--) {
            sum += Character.getNumericValue(value.charAt(i)) * heigth;
            heigth++;
            if (heigth > 9) {
                heigth = 2;
            }
        }

        int mod = sum % 11;
        int digit = (mod < 2) ? 0 : 11 - mod;

        return Character.getNumericValue(value.charAt(11)) == digit;
    }

	@Override
	public String getMessage() {
		return "Título Eleitoral inválido";
	}
}
