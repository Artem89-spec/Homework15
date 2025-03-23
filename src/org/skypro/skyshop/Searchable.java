package org.skypro.skyshop;

public interface Searchable {
    String getSearchTerm();

    String getTypeOfContent();

    default String getStringRepresentation() {
        return "Наименование: " + getSearchTerm() + " - " + "тип: " + getTypeOfContent();

    }
}
