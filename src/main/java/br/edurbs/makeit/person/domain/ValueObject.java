package br.edurbs.makeit.person.domain;

import br.edurbs.makeit.person.domain.validation.DefafultValidatorService;

public interface ValueObject {
    String value();
    public default void validate() {
        new DefafultValidatorService().validate(this);
    }
}
