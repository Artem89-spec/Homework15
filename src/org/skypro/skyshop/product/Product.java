package org.skypro.skyshop.product;

import org.skypro.skyshop.Searchable;

public abstract class Product implements Searchable {
    private final String productName;

    public Product(String productName) {
        if (productName == null) {
            throw new IllegalArgumentException("Введите название продукта");
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
        return productName.equals(object.productName);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(productName);
    }

}
