package org.skypro.skyshop.searchEngine;

import org.skypro.skyshop.Searchable;
import org.skypro.skyshop.exception.BestResultNotFound;

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

    public int count(String str, String subStr) {
        int count = 0;
        int index = 0;
        int indexSubStr = str.indexOf(subStr, index);
        while (indexSubStr != -1) {
            count++;
            index += indexSubStr + subStr.length();
            indexSubStr = str.indexOf(subStr, index);
        }
        return count;
    }

    public Searchable searchTheMostSuitableResult(String search) throws BestResultNotFound {
        if (search == null || search.isEmpty()) {
            throw new IllegalArgumentException("Введите наименование товара или его категорию");
        }
        Searchable mostSuitable = null;

        int maxCount = 0;
        for (Searchable searchable : contents) {
            if (searchable != null && searchable.getSearchTerm() != null) {
                String str = searchable.getSearchTerm().toLowerCase();
                String subStr = search.toLowerCase();
                int count = count(str, subStr);
                if (count > maxCount) {
                    maxCount = count;
                    mostSuitable = searchable;
                }
            }
        }
        if (mostSuitable == null) {
            throw new BestResultNotFound(search);
        }
        return mostSuitable;
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