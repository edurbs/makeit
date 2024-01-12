package br.edurbs.makeit.person.domain.validation;

public interface ValidatorService {
    <T> boolean isValid(T object);
}
