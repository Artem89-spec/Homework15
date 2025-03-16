package org.skypro.skyshop.product;

public abstract class Product {
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
    public String toString() {
        return productName  + " ";
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
