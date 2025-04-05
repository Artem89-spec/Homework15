package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;

public class ProductBasket {
    private final List<Product> products;

    public ProductBasket() {
        this.products = new LinkedList<>();
    }

    public List<Product> getProducts() {
        return new LinkedList<>(products);
    }

    public void addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Добавьте товар в корзину");
        }
        products.add(product);
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
        products.clear();
    }

    public List<Product> removeProductByName(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Введите наименование товара который необходимо удалить");
        }
        List<Product> removedProducts = new LinkedList<>();
        Iterator<Product> it = products.iterator();
        while (it.hasNext()) {
            Product product = it.next();
            if (product.getProductName().toLowerCase().contains(str.toLowerCase())) {
                removedProducts.add(product);
                it.remove();
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