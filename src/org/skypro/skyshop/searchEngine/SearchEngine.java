package org.skypro.skyshop.searchEngine;

import org.skypro.skyshop.Searchable;

import java.util.Arrays;


public class SearchEngine {
    private final Searchable[] contents;
    private final static int MAX_CONTENTS = 5;

    public SearchEngine(int size) {
        this.contents = new Searchable[size];
    }

    public Searchable[] search(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Введите наименование товара или его категорию");
        }

        Searchable[] results = new Searchable[MAX_CONTENTS];
        int index = 0;
        for (Searchable searchable : contents) {
            if (index >= MAX_CONTENTS) {
                break;
            }

            if (searchable != null && searchable.getSearchTerm() != null &&
                    searchable.getSearchTerm().contains(str)) {
                results[index] = searchable;
                index++;
            }
        }
        return results;
    }

    public void printSearch(Searchable[] results) {
        for (Searchable searchable : results) {
            if (searchable != null) {
                System.out.println(searchable.getStringRepresentation());
            }
        }
    }

    public void add(Searchable searchable) {
        if (searchable == null) {
            throw new IllegalArgumentException("Необходимо предоставить объект для добавления");
        }
        for (int i = 0; i < contents.length; i++) {
            if (contents[i] == null) {
                contents[i] = searchable;
                return;
            }

        }
        System.out.println("Невозможно добавить товар или категорию товара");
        System.out.println();
    }

    @Override
    public String toString() {
        return Arrays.toString(contents);
    }
}