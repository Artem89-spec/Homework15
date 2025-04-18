package org.skypro.skyshop.searchEngine;

import org.skypro.skyshop.Searchable;
import org.skypro.skyshop.exception.BestResultNotFound;

import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;


public class SearchEngine {
    private final List<Searchable> contents;

    public SearchEngine() {
        this.contents = new LinkedList<>();
    }

    public Map<String, Searchable> search(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Введите наименование товара или его категорию");
        }
        Map<String, Searchable> results = new TreeMap<>();
        for (Searchable searchable : contents) {
            if (searchable != null && searchable.getSearchTerm() != null &&
                    searchable.getSearchTerm().contains(name)) {
                results.put(searchable.getSearchTerm(), searchable);
            }
        }
        return results;
    }

    public void printSearch(Map<String, Searchable> results) {
        if (results.isEmpty()) {
            System.out.println("Товар или его категория не найдены.");
            return;
        }
        for (Map.Entry<String, Searchable> entry : results.entrySet()) {
            Searchable searchable = entry.getValue();
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