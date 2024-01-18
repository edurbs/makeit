package br.edurbs.makeit.person.domain.person.document;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import br.edurbs.makeit.person.domain.exception.DomainEntityValidationException;

class DocumentTest {

	DocumentType documentType = DocumentType.OUTRO;

	@Test
	void givenValidRg_whenValidate_thenReturnSuccess() {
		assertDoesNotThrow(() -> new Document(documentType, "some number"));
	}

	@Test
	void givenInvalidRg_whenValidate_thenThrowDomainEntityValidationException() {
		assertThrows(DomainEntityValidationException.class, () -> new Document(documentType, ""));
		assertThrows(DomainEntityValidationException.class, () -> new Document(documentType, null));
		assertThrows(DomainEntityValidationException.class, () -> new Document(null, "some number"));
	}

}
