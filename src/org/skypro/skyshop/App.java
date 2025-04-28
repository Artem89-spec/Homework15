package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.productCategories.Article;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.exception.BestResultNotFound;

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

        SearchEngine searchEngine = new SearchEngine();
        productBasket.addProduct(new DiscountedProduct("Мышь беспроводная", 1_500, 10));
        productBasket.addProduct(new SimpleProduct("Фронтальные колонки", 15_000));
        productBasket.addProduct(new DiscountedProduct("Наушники", 8_000, 5));
        productBasket.addProduct(new FixPriceProduct("Веб-камера"));
        productBasket.addProduct(new FixPriceProduct("Клавиатура"));
        for (Product product : productBasket.getAllProducts()) {
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

        productBasket.removeProductBasket();
        productBasket.printProductBasket();
        System.out.println();

        try {
            productBasket.addProduct(new FixPriceProduct(null));
            productBasket.addProduct(new FixPriceProduct(" "));
            productBasket.addProduct(new FixPriceProduct(""));
            productBasket.addProduct(new SimpleProduct(null, 1000));
            productBasket.addProduct(new SimpleProduct(" ", 1000));
            productBasket.addProduct(new SimpleProduct("", 1000));
            productBasket.addProduct(new DiscountedProduct(null, 5000, 5));
            productBasket.addProduct(new DiscountedProduct(" ", 5000, 5));
            productBasket.addProduct(new DiscountedProduct("", 5000, 5));
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

        try {
            productBasket.addProduct(new SimpleProduct("Процессор", -1000));
            productBasket.addProduct(new SimpleProduct("Процессор", 0));
            productBasket.addProduct(new DiscountedProduct("Мышь беспроводная", -500, 10));
            productBasket.addProduct(new DiscountedProduct("Мышь беспроводная", 0, 10));
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

        try {
            productBasket.addProduct(new DiscountedProduct("Мышь беспроводная", 500, 101));
            productBasket.addProduct(new DiscountedProduct("Мышь беспроводная", 500, -1));
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        } finally {
            System.out.println("Исключения обработаны.");
        }

        try {
            System.out.println(searchEngine.searchTheMostSuitableResult("периф"));
            System.out.println(searchEngine.searchTheMostSuitableResult("микрофон"));
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }

        productBasket.addProduct(new DiscountedProduct("Мышь беспроводная", 1_500, 10));
        productBasket.addProduct(new SimpleProduct("Фронтальные колонки", 15_000));
        productBasket.addProduct(new DiscountedProduct("Наушники", 8_000, 5));
        productBasket.addProduct(new FixPriceProduct("Веб-камера"));
        productBasket.addProduct(new FixPriceProduct("Клавиатура"));
        productBasket.addProduct(new FixPriceProduct("Веб-камера"));
        productBasket.addProduct(new SimpleProduct("Монитор", 40_000));
        productBasket.printProductBasket();
        System.out.println();


        productBasket.removeAndPrintRemovedProducts("веб");
        System.out.println();

        productBasket.printProductBasket();
        System.out.println();

        productBasket.removeAndPrintRemovedProducts("веб");
        System.out.println();

        productBasket.printProductBasket();
        System.out.println();

        Article article5 = new Article("Периферийные устройства", "Мышь проводная");
        Article article6 = new Article("Наушники и аудиотехника", "Фронтальные колонки 5.0");
        Article article7 = new Article("Периферийные устройства", "Клавиатура беспроводная");
        Article article8 = new Article("Периферийные устройства", "Камера");
        Article article9 = new Article("Наушники и аудиотехника", "Наушники беспроводные");
        Article article10 = new Article("Процессоры", "Процессор Intel Core i7 13700 KF");
        Article article11 = new Article("Процессоры", "Процессор Intel Core i7 13700 K");
        Article article12 = new Article("Процессоры", "Процессор Intel Core i9 13900 K");
        productBasket.addProduct(new DiscountedProduct("Мышь проводная", 1000, 5));
        productBasket.addProduct(new SimpleProduct("Фронтальные колонки 5.0", 33_000));
        productBasket.addProduct(new SimpleProduct("Наушники беспроводные", 9_000));
        productBasket.addProduct(new SimpleProduct("Процессор Intel Core i7 13700 KF", 26_000));
        productBasket.addProduct(new SimpleProduct("Процессор Intel Core i7 13700 K", 35_000));
        productBasket.addProduct(new DiscountedProduct("Клавиатура беспроводная", 15_000, 13));
        productBasket.addProduct(new FixPriceProduct("Камера"));
        for (Product product : productBasket.getAllProducts()) {
            if (product != null) {
                searchEngine.add(product);
            }
        }
        searchEngine.add(article5);
        searchEngine.add(article6);
        searchEngine.add(article7);
        searchEngine.add(article8);
        searchEngine.add(article9);
        searchEngine.add(article10);
        searchEngine.add(article11);
        searchEngine.add(article12);
        System.out.println(searchEngine);
        searchEngine.printSearch(searchEngine.search("Мышь"));
        System.out.println();
        searchEngine.printSearch(searchEngine.search("Проц"));
        System.out.println();
        searchEngine.printSearch(searchEngine.search("кам"));
        System.out.println();
        searchEngine.printSearch(searchEngine.search("периф"));
        System.out.println();
        searchEngine.printSearch(searchEngine.search("аудио"));
        System.out.println();
        productBasket.printProductBasket();
    }
}