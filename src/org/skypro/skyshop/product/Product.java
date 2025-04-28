package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

import java.util.Objects;

public abstract class Product implements Searchable {
    private final String productName;

    public Product(String productName) {
        if (productName == null  || productName.trim().isEmpty()) {
            throw new IllegalArgumentException("Введите корректное название продукта, оно не может быть пустым или содержать пробелы.");
        }
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public abstract double getPrice();

    public abstract String getFormattedPrice();

    public abstract boolean isSpecial();

    @Override
    public String getSearchTerm() {
        return productName;
    }

    @Override
    public String getTypeOfContent() {
        return "PRODUCT";
    }

    @Override
    public String toString() {
        return productName + " ";
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        } else if (other == null || this.getClass() != other.getClass()) {
            return false;
        }
        Product object = (Product) other;
        return Objects.equals(productName, object.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productName);
    }

}
