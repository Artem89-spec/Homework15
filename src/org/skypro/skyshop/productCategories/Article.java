package org.skypro.skyshop.productCategories;

import org.skypro.skyshop.search.Searchable;

import java.util.Objects;

public final class Article implements Searchable {
    private final String articleTitle;
    private final String contentOfArticle;

    public Article(String articleTitle, String contentOfArticle) {
        this.articleTitle = articleTitle;
        this.contentOfArticle = contentOfArticle;
    }

    @Override
    public String toString() {
        return articleTitle + " " + contentOfArticle;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        } else if (this.getClass() != other.getClass()) {
            return false;
        }
        Article object = (Article) other;
        return Objects.equals(contentOfArticle, object.contentOfArticle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contentOfArticle);
    }

    @Override
    public String getSearchTerm() {
        return toString();
    }

    @Override
    public String getTypeOfContent() {
        return "ARTICLE";
    }
}
