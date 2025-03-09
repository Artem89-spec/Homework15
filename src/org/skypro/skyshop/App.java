package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;



public class App {
    public static void main(String[] args) {
        ProductBasket productBasket = new ProductBasket();
        productBasket.addProduct(new Product("Клавиатура", 5_000));
        productBasket.addProduct(new Product("Мышь беспроводная",  1_500));
        productBasket.addProduct(new Product("Фронтальные колонки", 15_000));
        productBasket.addProduct(new Product("Наушники", 8_000));
        System.out.println();

        productBasket.printProductBasket();
        System.out.println();

        productBasket.addProduct(new Product("Монитор", 40_000));
        productBasket.addProduct(new Product("Камера", 9_000));
        productBasket.printProductBasket();
        System.out.println();

        System.out.println(productBasket.searchProductByName("Мышь беспроводная"));
        System.out.println();

        System.out.println(productBasket.searchProductByName("Камера"));
        System.out.println();

        productBasket.removeProductBasket();
        productBasket.printProductBasket();
        System.out.println();

        System.out.println(productBasket.searchProductByName("Наушники"));
    }
}