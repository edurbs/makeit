package br.edurbs.makeit.person.domain.person.document;

public interface Document {
    boolean isValid();

    DocumentType getDocumentType();

    void setDocumentType(DocumentType documentType);

    String getNumber();

    void setNumber(String number);
}
