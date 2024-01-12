package br.edurbs.makeit.person.domain.entity.maindocument;

import br.edurbs.makeit.person.domain.entity.exception.InvalidCnpjException;
import br.edurbs.makeit.person.domain.entity.exception.InvalidCpfException;

public interface MainDocument {
    String getNumber();

    void setNumber(String number)
            throws InvalidCnpjException, InvalidCpfException;
}
