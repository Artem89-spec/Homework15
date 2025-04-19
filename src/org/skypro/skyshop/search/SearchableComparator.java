package org.skypro.skyshop.search;

import java.util.Comparator;

public class SearchableComparator implements Comparator<Searchable> {

    @Override
    public int compare(Searchable obj1, Searchable obj2) {
        int lengthCompare = Integer.compare(obj2.getSearchTerm().length(), obj1.getSearchTerm().length());
        if (lengthCompare != 0) {
            return lengthCompare;
        } else {
            return obj1.getSearchTerm().compareTo(obj2.getSearchTerm());
        }
    }
}
