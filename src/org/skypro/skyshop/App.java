package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.productCategories.Article;
import org.skypro.skyshop.searchEngine.SearchEngine;


public class App {
    public static void main(String[] args) {
        ProductBasket productBasket = new ProductBasket();
        productBasket.addProduct(new FixPriceProduct("Клавиатура"));
        productBasket.addProduct(new DiscountedProduct("Мышь беспроводная", 1_500, 10));
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
        System.out.println();

        SearchEngine searchEngine = new SearchEngine(15);
        productBasket.addProduct(new DiscountedProduct("Мышь беспроводная", 1_500, 10));
        productBasket.addProduct(new SimpleProduct("Фронтальные колонки", 15_000));
        productBasket.addProduct(new DiscountedProduct("Наушники", 8_000, 5));
        productBasket.addProduct(new FixPriceProduct("Веб-камера"));
        productBasket.addProduct(new FixPriceProduct("Клавиатура"));
        for (Product product : productBasket.getProducts()) {
            if (product != null) {
                searchEngine.add(product);
            }
        }
        System.out.println(searchEngine);
        System.out.println();

        Article article = new Article("Периферийные устройства", "Мышь беспроводная");
        Article article1 = new Article("Наушники и аудиотехника", "Фронтальные колонки");
        Article article2 = new Article("Периферийные устройства", "Клавиатура");
        Article article3 = new Article("Периферийные устройства", "Веб-камера");
        Article article4 = new Article("Наушники и аудиотехника", "Наушники");
        searchEngine.add(article);
        searchEngine.add(article1);
        searchEngine.add(article2);
        searchEngine.add(article3);
        searchEngine.add(article4);
        System.out.println(searchEngine);
        System.out.println();

        searchEngine.printSearch(searchEngine.search("Наушники"));
        System.out.println();
        searchEngine.printSearch(searchEngine.search("устройства"));
        System.out.println();
        searchEngine.printSearch(searchEngine.search("Клавиатура"));
        System.out.println();
        searchEngine.printSearch(searchEngine.search("Веб"));
        System.out.println();
    }
}