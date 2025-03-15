package org.skypro.skyshop.basket;
import org.skypro.skyshop.product.Product;

import java.util.Arrays;

public class ProductBasket {
    private final Product[] products;
    private final static int MAX_PRODUCT_BASKET = 5;


    public ProductBasket() {
        this.products = new Product[MAX_PRODUCT_BASKET];
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

    public int getTotalPrice() {
        int total = 0;
        for (Product product : products) {
            if (product != null) {
                total += product.getPrice();
            }
        }
        return total;
    }

    public void printProductBasket() {
        int counter = 0;
        for (Product product : products) {
            if (product != null) {
                System.out.println(product);
                counter++;
            }
        }
        String formattedPrice = String.format("%,d", getTotalPrice());
        if (counter == 0) {
            System.out.println("В корзине пусто");
            System.out.printf("Общая стоимость корзины: %s%n", formattedPrice);
        } else {
            System.out.printf("Общая стоимость корзины: %s%n", formattedPrice);
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