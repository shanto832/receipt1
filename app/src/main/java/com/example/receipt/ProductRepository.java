package com.example.receipt;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private final List<Product> availableProducts;

    public ProductRepository() {
        availableProducts = new ArrayList<>();
        availableProducts.add(new Product("Chocolate", 3.0));
        availableProducts.add(new Product("Chips", 2.0));
    }

    public List<Product> getAvailableProducts() {
        return availableProducts;
    }

    public double calculateTotalPrice(int quantity, boolean isChocolateSelected, boolean isChipsSelected) {
        double totalPrice = 0.0;
        for (Product product : availableProducts) {
            if (isChocolateSelected && product.getName().equals("Chocolate")) {
                totalPrice += product.getPrice() * quantity;
            }
            if (isChipsSelected && product.getName().equals("Chips")) {
                totalPrice += product.getPrice() * quantity;
            }
        }
        return totalPrice;
    }
}
