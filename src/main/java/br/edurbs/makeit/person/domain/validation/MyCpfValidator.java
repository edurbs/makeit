package br.edurbs.makeit.person.domain.validation;

import br.edurbs.makeit.person.domain.person.exception.DomainEntityValidationException;

/*
 * This class is a copy of the CPFValidator class from the stella-core library.
 * https://github.com/caelum/caelum-stella/blob/master/stella-core/src/main/java/br/com/caelum/
 * stella/validation/CPFValidator.java
 */

public class MyCpfValidator implements CpfValidation {

	private void isInvalid(){
		throw new DomainEntityValidationException("Cpf.value: CPF inválido");
	}

	public void validate(String cpf){

        if (cpf == null) {
			return;
        }

		if(cpf.length() != 11 || !cpf.matches("\\d*") || hasAllRepeatedDigits(cpf)) {
            isInvalid();
        }


        String cpfSemDigito = cpf.substring(0, cpf.length() - 2);
        String digitos = cpf.substring(cpf.length() - 2);

		if (!digitos.equals(calculaDigitos(cpfSemDigito))) {
			isInvalid();
		}
		
    }

    /**
     * Faz o cálculo dos digitos usando a lógica de CPF
     * 
     * @return String os dois dígitos calculados.
     */
    private String calculaDigitos(String cpfSemDigito) {
        DigitoPara digitoPara = new DigitoPara(cpfSemDigito);
        digitoPara.comMultiplicadoresDeAte(2, 11).complementarAoModulo().trocandoPorSeEncontrar("0", 10, 11).mod(11);

        String digito1 = digitoPara.calcula();
        digitoPara.addDigito(digito1);
        String digito2 = digitoPara.calcula();

        return digito1 + digito2;
    }

    private boolean hasAllRepeatedDigits(String cpf) {
        for (int i = 1; i < cpf.length(); i++) {
            if (cpf.charAt(i) != cpf.charAt(0)) {
                return false;
            }
        }
        return true;
    }

}
