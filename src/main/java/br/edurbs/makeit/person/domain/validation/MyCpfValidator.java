package br.edurbs.makeit.person.domain.validation;

import br.edurbs.makeit.person.domain.validation.annotation.ValidCPF;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/*
 * This class is based on CPFValidator class from the stella-core library.
 * https://github.com/caelum/caelum-stella/blob/master/stella-core/src/main/java/br/com/caelum/
 * stella/validation/CPFValidator.java
 */

public class MyCpfValidator implements ConstraintValidator<ValidCPF, String> {

	@Override
	public boolean isValid(String cpf, ConstraintValidatorContext context) {
		if (cpf == null) {
			return true;
		}
		if (cpf.length() != 11 || !cpf.matches("\\d*") || hasAllRepeatedDigits(cpf)) {
			return false;
		}
		String cpfSemDigito = cpf.substring(0, cpf.length() - 2);
		String digitos = cpf.substring(cpf.length() - 2);
		return digitos.equals(calculaDigitos(cpfSemDigito));
	}

	private boolean hasAllRepeatedDigits(String cpf) {
		return cpf.chars().filter(Character::isDigit).distinct().count() == 1;
	}

	/*
	 * This method is a copy from the stella-core library https://github.com/caelum/caelum-stella/
	 */
	private String calculaDigitos(String cpfSemDigito) {
		DigitoPara digitoPara = new DigitoPara(cpfSemDigito);
		digitoPara.comMultiplicadoresDeAte(2, 11).complementarAoModulo()
				.trocandoPorSeEncontrar("0", 10, 11).mod(11);

		String digito1 = digitoPara.calcula();
		digitoPara.addDigito(digito1);
		String digito2 = digitoPara.calcula();

		return digito1 + digito2;
	}
}
