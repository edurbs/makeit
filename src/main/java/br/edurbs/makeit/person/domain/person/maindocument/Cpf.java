package br.edurbs.makeit.person.domain.person.maindocument;


import br.edurbs.makeit.person.domain.ValueObject;
import br.edurbs.makeit.person.domain.validation.annotation.ValidCPF;
import jakarta.validation.constraints.NotBlank;

public record Cpf(@ValidCPF(message = "CPF inválido") @NotBlank String value)
		implements MainDocument, ValueObject {
	public Cpf(String value) {
		this.value = value.replaceAll("\\D+", "");
		this.validate();
	}

	public String cpfWithMask() {
		var cpf = this.value;
		cpf = cpf.substring(0, 3)
				+ "." + cpf.substring(3, 6)
				+ "." + cpf.substring(6, 9)
				+ "-" + cpf.substring(9, 11);
		return cpf;
	}
}
