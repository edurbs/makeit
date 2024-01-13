package br.edurbs.makeit.person.domain;

import br.edurbs.makeit.person.domain.validation.EntityValidatorService;

public interface ValueObject {
    String value();
    public default void validate() {
        new EntityValidatorService().validate(this);
    }
}
