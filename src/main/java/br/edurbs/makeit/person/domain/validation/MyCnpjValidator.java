package br.edurbs.makeit.person.domain.validation;

import br.edurbs.makeit.person.domain.person.exception.DomainEntityValidationException;

/*
 * This class is a copy of the CNPJValidator class from the stella-core library.
 * from https://github.com/caelum/caelum-stella/blob/master/stella-core/src/main/java/br/com/caelum/
 * stella/validation/CNPJValidator.java
 */
public class MyCnpjValidator implements CnpjValidator {

	public void validate(String cnpj) {

		if (cnpj == null) {
			return;
		}

		if (cnpj.length() != 14 || hasAllRepeatedDigits(cnpj)) {
			isInvalid();
		}

		String cnpjSemDigito = cnpj.substring(0, cnpj.length() - 2);
		String digitos = cnpj.substring(cnpj.length() - 2);
		if (!calculaDigitos(cnpjSemDigito).equals(digitos)) {
			isInvalid();
		}

	}

	private void isInvalid(){
		throw new DomainEntityValidationException("Cnpj.value: CNPJ inválido");
	}

	private String calculaDigitos(String cnpjSemDigito) {
		DigitoPara digitoPara = new DigitoPara(cnpjSemDigito);
		digitoPara.complementarAoModulo().trocandoPorSeEncontrar("0", 10, 11).mod(11);

		String digito1 = digitoPara.calcula();
		digitoPara.addDigito(digito1);
		String digito2 = digitoPara.calcula();

		return digito1 + digito2;
	}

	private boolean hasAllRepeatedDigits(String cnpj) {
		return cnpj.chars().filter(Character::isDigit).distinct().count() == 1;
	}

}
