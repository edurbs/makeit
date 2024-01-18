package br.edurbs.makeit.person.domain.person.document;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class DocumentTypeTest {
	@Test
	void givenDocumentType_whenGetName_thenReturnName() {
		assertEquals("Registro Geral", DocumentType.RG.getName());
	}
}
