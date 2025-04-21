package org.skypro.skyshop.search;

public interface Searchable {
    String getSearchTerm();

    String getTypeOfContent();

    default String getStringRepresentation() {
        return "Наименование: " + getSearchTerm() + " - " + "тип: " + getTypeOfContent();

    }
}
