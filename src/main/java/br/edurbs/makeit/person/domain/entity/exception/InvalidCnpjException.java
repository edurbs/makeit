package br.edurbs.makeit.person.domain.entity.exception;

public class InvalidCnpjException extends RuntimeException {

    public InvalidCnpjException() {
        super("Invalid CNPJ number exception");
    }

}
