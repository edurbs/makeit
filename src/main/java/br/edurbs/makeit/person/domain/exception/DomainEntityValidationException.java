package br.edurbs.makeit.person.domain.exception;

public class DomainEntityValidationException extends RuntimeException {

    public DomainEntityValidationException(String message) {
        super(message);
    }

}
