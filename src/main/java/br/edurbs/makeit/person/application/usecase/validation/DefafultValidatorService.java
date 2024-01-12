package br.edurbs.makeit.person.application.usecase.validation;

import org.springframework.stereotype.Service;
import br.edurbs.makeit.person.domain.validation.ValidatorService;
import jakarta.validation.Validation;
import jakarta.validation.Validator;

@Service
public class DefafultValidatorService implements ValidatorService {
    private final Validator validator;

    public  DefafultValidatorService() {
        this.validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Override
    public <T> boolean isValid(T object) {
        return validator.validate(object).isEmpty();
    }
}
