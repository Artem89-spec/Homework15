package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Arrays;

public class ProductBasket {
    private final Product[] products;
    private final static int MAX_PRODUCT_BASKET = 5;


    public ProductBasket() {
        this.products = new Product[MAX_PRODUCT_BASKET];
    }

    public Product[] getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Добавьте товар в корзину");
        }
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                products[i] = product;
                return;
            }
        }
        System.out.println("Невозможно добавить продукт");
        System.out.println();
    }

    public double getTotalPrice() {
        double total = 0;
        for (Product product : products) {
            if (product != null) {
                total += product.getPrice();
            }
        }
        return total;
    }

    public void printProductBasket() {
        int counter = 0;
        int specialProduct = 0;

        for (Product product : products) {
            if (product != null) {
                System.out.println(product);
                counter++;
                specialProduct += product.isSpecial() ? 1 : 0;
            }
        }
        String formattedPrice = String.format("%,.2f", getTotalPrice()).replace(',', '.');
        if (counter == 0) {
            System.out.println("В корзине пусто");
            System.out.printf("Итого: %s%n", formattedPrice);
        } else {
            System.out.printf("Итого: %s%n", formattedPrice);
            System.out.printf("Специальных товаров: %d%n", specialProduct);
        }
    }

    public boolean searchProductByName(String str) {
        for (Product product : products) {
            if (product != null && str.equals(product.getProductName())) {
                return true;
            }
        }
        return false;
    }

    public void removeProductBasket() {
        Arrays.fill(products, null);
    }
}