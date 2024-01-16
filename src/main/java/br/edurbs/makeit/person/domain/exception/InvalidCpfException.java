package br.edurbs.makeit.person.domain.exception;

public class InvalidCpfException extends RuntimeException {

    public InvalidCpfException() {
        super("Invalid CNPJ number exception");
    }

}
