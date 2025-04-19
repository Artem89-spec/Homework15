package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

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
        double total = 0;
        for (List<Product> productList : products.values()) {
            for (Product product : productList) {
                if (product != null) {
                    total += product.getPrice();
                }
            }
        }
        return total;
    }

    public void printProductBasket() {
        int counter = 0;
        int specialProduct = 0;

        for (List<Product> productList : products.values()) {
            for (Product product : productList) {
                if (product != null) {
                    System.out.println(product);
                    counter++;
                    specialProduct += product.isSpecial() ? 1 : 0;
                }
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