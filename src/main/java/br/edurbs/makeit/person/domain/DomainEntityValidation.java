package br.edurbs.makeit.person.domain;

import java.util.Set;
import java.util.stream.Collectors;
import br.edurbs.makeit.person.domain.person.exception.DomainEntityValidationException;
import br.edurbs.makeit.person.domain.validation.DefafultValidatorService;
import jakarta.validation.ConstraintViolation;

public abstract class DomainEntityValidation implements DomainEntity {

    public void validate(){
        var validatorService = new DefafultValidatorService();
        Set<ConstraintViolation<DomainEntityValidation>> violations = validatorService.validate(this);

        if (!violations.isEmpty()) {
            throw new DomainEntityValidationException(violations.stream()
                    .map(ConstraintViolation::getMessage).collect(Collectors.joining(", ")));
        }

    }
}
