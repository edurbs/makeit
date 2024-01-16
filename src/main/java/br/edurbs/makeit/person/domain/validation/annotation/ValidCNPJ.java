package br.edurbs.makeit.person.domain.validation.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import br.edurbs.makeit.person.domain.validation.MyCnpjValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Constraint(validatedBy = MyCnpjValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidCNPJ {
	String message() default "Invalid CNPJ";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
