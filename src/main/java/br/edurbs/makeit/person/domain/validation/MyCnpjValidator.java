package br.edurbs.makeit.person.domain.validation;

import br.edurbs.makeit.person.domain.validation.annotation.ValidCNPJ;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class MyCnpjValidator implements ConstraintValidator<ValidCNPJ, String> {

	@Override
	public boolean isValid(String cnpj, ConstraintValidatorContext context) {
		if (cnpj == null) {
			return true;
		}
		if (cnpj.length() != 14 || !cnpj.matches("\\d*") || hasAllRepeatedDigits(cnpj)) {
			return false;
		}
		String cnpjSemDigito = cnpj.substring(0, cnpj.length() - 2);
		String digitos = cnpj.substring(cnpj.length() - 2);
		return calculaDigitos(cnpjSemDigito).equals(digitos);
	}

	private boolean hasAllRepeatedDigits(String cnpj) {
		return cnpj.chars().filter(Character::isDigit).distinct().count() == 1;
	}

	/*
	 * This method is a copy from the stella-core library https://github.com/caelum/caelum-stella/
	 */
	private String calculaDigitos(String cnpjSemDigito) {
		DigitoPara digitoPara = new DigitoPara(cnpjSemDigito);
		digitoPara.complementarAoModulo().trocandoPorSeEncontrar("0", 10, 11).mod(11);

		String digito1 = digitoPara.calcula();
		digitoPara.addDigito(digito1);
		String digito2 = digitoPara.calcula();

		return digito1 + digito2;
	}

}
