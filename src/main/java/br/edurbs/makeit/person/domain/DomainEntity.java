package br.edurbs.makeit.person.domain;

import br.edurbs.makeit.person.domain.validation.EntityValidatorService;

public interface DomainEntity {
    public default void validate() {
        new EntityValidatorService().validate(this);
    }
}
