package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;



public class App {
    public static void main(String[] args) {
        ProductBasket productBasket = new ProductBasket();
        productBasket.addProduct(new FixPriceProduct("Клавиатура"));
        productBasket.addProduct(new DiscountedProduct("Мышь беспроводная",  1_500, 10));
        productBasket.addProduct(new SimpleProduct("Фронтальные колонки", 15_000));
        productBasket.addProduct(new DiscountedProduct("Наушники", 8_000, 5));
        System.out.println();

        productBasket.printProductBasket();
        System.out.println();

        productBasket.addProduct(new FixPriceProduct("Веб-камера"));
        productBasket.addProduct(new SimpleProduct("Монитор", 40_000));
        productBasket.printProductBasket();
        System.out.println();

        System.out.println(productBasket.searchProductByName("Мышь беспроводная"));
        System.out.println();

        System.out.println(productBasket.searchProductByName("Монитор"));
        System.out.println();

        productBasket.removeProductBasket();
        productBasket.printProductBasket();
        System.out.println();

        System.out.println(productBasket.searchProductByName("Наушники"));
    }
}