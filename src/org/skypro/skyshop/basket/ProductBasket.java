package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;
import java.util.stream.Stream;

public class ProductBasket {
    private final Map<String, List<Product>> products;

    public ProductBasket() {
        this.products = new HashMap<>();
    }

    public List<Product> getProducts(String nameProduct) {
        return products.getOrDefault(nameProduct, new LinkedList<>());
    }

    public List<Product> getAllProducts() {
        List<Product> allProducts = new LinkedList<>();
        for (List<Product> products : products.values()) {
            allProducts.addAll(products);
        }
        return allProducts;
    }

    public void addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Добавьте товар в корзину");
        }
        products.computeIfAbsent(product.getProductName(), K -> new LinkedList<>()).add(product);
        System.out.println();
    }

    public double getTotalPrice() {
        return getProductsStream()
                .mapToDouble(Product::getPrice)
                .sum();
    }

    public void printProductBasket() {
        Stream<Product> productStream = getProductsStream();
        productStream.forEach(System.out::println);
        long specialProduct = getSpecialCount();
        String formattedPrice = String.format("%,.2f", getTotalPrice()).replace(',', '.');
        if (getProductsCount() == 0) {
            System.out.println("В корзине пусто");
            System.out.printf("Итого: %s%n", formattedPrice);
        } else {
            System.out.printf("Итого: %s%n", formattedPrice);
            System.out.printf("Специальных товаров: %d%n", specialProduct);
        }
    }

    private Stream<Product> getProductsStream() {
        return products.values().stream()
                .flatMap(List::stream)
                .filter(Objects::nonNull);
    }

    public long getSpecialCount() {
        return getProductsStream()
                .filter(Product::isSpecial)
                .count();
    }

    public long getProductsCount() {
        return getProductsStream()
                .count();
    }

    public boolean searchProductByName(String productName) {
        List<Product> productList = getProducts(productName);
        return !productList.isEmpty();
    }

    public void removeProductBasket() {
        products.clear();
    }

    public List<Product> removeProductByName(String productName) {
        if (productName == null || productName.isEmpty()) {
            throw new IllegalArgumentException("Введите наименование товара который необходимо удалить");
        }
        List<Product> removedProducts = new LinkedList<>();
        List<Product> productList = getProducts(productName);
        if (productList != null && !productList.isEmpty()) {
            Iterator<Product> iterator = productList.iterator();
            while (iterator.hasNext()) {
                Product product = iterator.next();
                if (product.getProductName().toLowerCase().contains(productName.toLowerCase())) {
                    removedProducts.add(product);
                    iterator.remove();
                }
            }
            if (productList.isEmpty()) {
                products.remove(productName);
            }
        }
        return removedProducts;
    }

    public void removeAndPrintRemovedProducts(String productName) {
        List<Product> removedProducts = removeProductByName(productName);
        if (removedProducts.isEmpty()) {
            System.out.println("Список пуст");
        } else {
            System.out.println("Список удаленных товаров:");
            for (Product product : removedProducts) {
                System.out.println(product);
            }
        }
    }
}