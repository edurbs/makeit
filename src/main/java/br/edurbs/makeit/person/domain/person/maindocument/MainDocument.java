package br.edurbs.makeit.person.domain.person.maindocument;

public sealed interface MainDocument permits Cpf, Cnpj {
    String getNumber();
}
