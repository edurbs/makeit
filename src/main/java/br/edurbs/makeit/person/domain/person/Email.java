package br.edurbs.makeit.person.domain.person;

import br.edurbs.makeit.person.domain.DomainEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;
import lombok.Getter;

@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Email implements DomainEntity {

	@Include
	@NotBlank
    String id;

    @NotNull
    EmailType emailType;

    @NotNull
    EmailAddress emailAddress;

	public Email(@NotBlank String id, EmailType emailType, EmailAddress emailAddress) {
		this.id = id;
		this.emailType = emailType;
		this.emailAddress = emailAddress;
		this.validate();
	}

	public void setId(String id) {
		this.id = id;
		this.validate();
	}

	public void setEmailType(EmailType emailType) {
		this.emailType = emailType;
		this.validate();
	}

	public void setEmailAddress(EmailAddress emailAddress) {
		this.emailAddress = emailAddress;
		this.validate();
	}



}
