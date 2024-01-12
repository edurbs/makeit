package br.edurbs.makeit.person.domain.person.exception;

public class InvalidCpfException extends RuntimeException {

    public InvalidCpfException() {
        super("Invalid CNPJ number exception");
    }

}
