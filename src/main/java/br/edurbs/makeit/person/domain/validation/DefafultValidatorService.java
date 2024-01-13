package br.edurbs.makeit.person.domain.validation;

import java.util.Set;
import java.util.stream.Collectors;
import br.edurbs.makeit.person.domain.person.exception.DomainEntityValidationException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;

public class DefafultValidatorService {
    private final Validator validator;

    public DefafultValidatorService() {
        this.validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    public <T> void validate(T object) {
        Set<ConstraintViolation<T>> violations = this.validator.validate(object);
        if (!violations.isEmpty()) {
            throw new DomainEntityValidationException(violations.stream()
                    .map(ConstraintViolation::getMessage)
                    .collect(Collectors.joining(", ")));
        }
    }

}
