package br.edurbs.makeit.person.domain.person.document;

import java.util.Map;
import br.edurbs.makeit.person.domain.ValueObject;
import br.edurbs.makeit.person.domain.exception.DomainEntityValidationException;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record Document(@NotNull DocumentType documentType, @NotBlank String value)
		implements ValueObject {
	public Document(DocumentType documentType, String value) {
		this.documentType = documentType;
		this.value = value;
		validate();
		Map<DocumentType, DocumentValidator> validators = Map.of(
				DocumentType.CNH, new CnhValidator(),
				DocumentType.RG, new DocumentWithOutValidation(),
				DocumentType.PASSAPORTE, new PassaporteValidator(),
				DocumentType.TITULO_ELEITORAL, new TituloEleitoralValidator(),
				DocumentType.IE, new DocumentWithOutValidation(),
				DocumentType.IM, new DocumentWithOutValidation(),
				DocumentType.OUTRO, new DocumentWithOutValidation());

		if (!validators.get(documentType).isValid(value)) {
			var msg = validators.get(documentType).getMessage();
			throw new DomainEntityValidationException(msg);
		}
	}
}
