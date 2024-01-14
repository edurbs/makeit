package br.edurbs.makeit.person.domain.validation;

import br.edurbs.makeit.person.domain.person.exception.DomainEntityValidationException;

public interface PhoneValidator {
    void validate(String number) throws DomainEntityValidationException;
}
