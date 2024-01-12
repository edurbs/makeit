package br.edurbs.makeit.person.domain.entity;

import java.util.Set;
import java.util.stream.Collectors;
import br.edurbs.makeit.person.domain.entity.exception.DomainEntityValidationException;
import br.edurbs.makeit.person.domain.validation.DefafultValidatorService;
import jakarta.validation.ConstraintViolation;

public abstract class DomainEntityAbstract implements DomainEntity {

    public void validate(){
        var validatorService = new DefafultValidatorService();
        Set<ConstraintViolation<DomainEntityAbstract>> violations = validatorService.validate(this);

        if (!violations.isEmpty()) {
            throw new DomainEntityValidationException(violations.stream()
                    .map(ConstraintViolation::getMessage).collect(Collectors.joining(", ")));
        }

    }
}
