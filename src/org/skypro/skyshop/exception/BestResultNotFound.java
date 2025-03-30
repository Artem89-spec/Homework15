package org.skypro.skyshop.exception;


public class BestResultNotFound extends Exception {
    private final String searchQuery;

    public BestResultNotFound(String nameProduct) {
        this.searchQuery = nameProduct;
    }

    @Override
    public String getMessage() {
        return "Для указанного поискового запроса { " + searchQuery + " } не найдено подходящей категории товара.";
    }
}
