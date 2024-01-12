package br.edurbs.makeit.person.domain.person.exception;

public class DomainEntityValidationException extends RuntimeException {

    public DomainEntityValidationException(String message) {
        super(message);
    }

}
