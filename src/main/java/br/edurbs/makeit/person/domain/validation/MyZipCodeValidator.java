package br.edurbs.makeit.person.domain.validation;

import br.edurbs.makeit.person.domain.validation.annotation.ValidZipCode;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class MyZipCodeValidator implements ConstraintValidator<ValidZipCode, String> {

	private String country;

	@Override
	public void initialize(ValidZipCode constraintAnnotation) {
		this.country = constraintAnnotation.country();
	}

    @Override
	public boolean isValid(String zipCode, ConstraintValidatorContext context) {
		String defaultCountry = "Brasil";
		if (zipCode == null || !this.country.equals(defaultCountry)) {
			return true;
		}
		if (zipCode.length() != 8) {
			return false;
		}
		return !zipCode.isBlank()
				&& this.country.equals(defaultCountry)
				&& zipCode.matches("\\d{8}");
    }

}
