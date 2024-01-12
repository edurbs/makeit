package br.edurbs.makeit.person.domain.validation;

import java.util.Set;
import org.springframework.stereotype.Service;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;

@Service
public class DefafultValidatorService {
    private final Validator validator;

    public  DefafultValidatorService() {
        this.validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    // public <T> boolean isValid(T object) {
    //     return validator.validate(object).isEmpty();
    // }

    public <T> Set<ConstraintViolation<T>> validate(T object) {
        return validator.validate(object);
    }
}
