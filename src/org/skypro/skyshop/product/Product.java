package org.skypro.skyshop.product;

public class Product {
    private String productName;
    private int price;

    public Product(String productName, int price) {
        if (productName == null) {
            throw new IllegalArgumentException("Введите название продукта");
        } else if (price <= 0) {
            throw new IllegalArgumentException("Установите цену продукта");
        }
        this.productName = productName;
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public int getPrice() {
        return price;
    }

    public String getFormattedPrice() {
        return String.format("%,d", price).replace(',', ' ');
    }

    @Override
    public String toString() {
        return  productName  + ": " + "  " + getFormattedPrice();
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        } else if (other == null || this.getClass() != other.getClass()) {
            return false;
        }
        Product object = (Product) other;
        return productName.equals(object.productName) && price == object.price;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(productName, price);
    }
}
