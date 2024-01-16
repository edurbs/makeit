package br.edurbs.makeit.person.domain.validation.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import br.edurbs.makeit.person.domain.validation.MyCpfValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Constraint(validatedBy = MyCpfValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidCPF {
	String message() default "Invalid CPF";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
