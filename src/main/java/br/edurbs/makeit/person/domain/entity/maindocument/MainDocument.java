package br.edurbs.makeit.person.domain.entity.maindocument;

public sealed interface MainDocument permits Cpf, Cnpj {
    String getNumber();
}
