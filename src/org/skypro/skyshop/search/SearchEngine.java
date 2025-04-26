package org.skypro.skyshop.search;

import org.skypro.skyshop.exception.BestResultNotFound;

import java.util.*;
import java.util.stream.Collectors;


public class SearchEngine {
    private final Set<Searchable> contents;

    public SearchEngine() {
        this.contents = new HashSet<>();
    }

    public Set<Searchable> search(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Введите наименование товара или его категорию");
        }
        return contents.stream()
                .filter(Objects::nonNull)
                .filter(searchable ->  searchable.getSearchTerm() != null &&
                        searchable.getSearchTerm().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toCollection(() -> new TreeSet<>(new SearchableComparator())));
    }

    public void printSearch(Set<Searchable> results) {
        if (results.isEmpty()) {
            System.out.println("Товар или его категория не найдены.");
            return;
        }
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

    public Searchable searchTheMostSuitableResult(String search) {
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
        contents.add(searchable);
    }

    @Override
    public String toString() {
        return contents.toString();
    }
}