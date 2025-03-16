package org.skypro.skyshop.product;


public class DiscountedProduct extends Product {
    private final double basePrice;
    private final int percentageDiscount;
    private static final int PERCENT = 100;

    public DiscountedProduct(String productName, int basePrice, int percentageDiscount) {
        super(productName);
        if (basePrice <= 0) {
            throw new IllegalArgumentException("Установите цену товара");
        }
        this.basePrice = basePrice;
        this.percentageDiscount = percentageDiscount;
    }

    @Override
    public double getPrice() {
        return basePrice - (basePrice * percentageDiscount / PERCENT);
    }

    @Override
    public String getFormattedPrice() {
        return String.format("%,.2f", getPrice()).replace(',', '.');
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + "со скидкой: " + getFormattedPrice() + " (" + percentageDiscount + "%" + ")";
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || this.getClass() != other.getClass()) {
            return false;
        }
        DiscountedProduct object = (DiscountedProduct) other;
        return super.equals(object) && Double.compare(basePrice, object.basePrice) == 0 &&
                percentageDiscount == object.percentageDiscount;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), basePrice, percentageDiscount);
    }
}
