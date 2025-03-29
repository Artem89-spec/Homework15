package org.skypro.skyshop.productCategories;

import org.skypro.skyshop.Searchable;

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
        } else if (other == null || this.getClass() != other.getClass()) {
            return false;
        }

        Article object = (Article) other;
        return articleTitle.equals(object.articleTitle) &&
                contentOfArticle.equals(object.contentOfArticle);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(articleTitle, contentOfArticle);
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
