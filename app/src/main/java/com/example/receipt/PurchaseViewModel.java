package com.example.receipt;

import androidx.lifecycle.ViewModel;

public class PurchaseViewModel extends ViewModel {

    public double calculateTotalPrice(boolean isChocolateSelected, boolean isChipsSelected, int quantity) {
        double totalPrice = 0;

        // Price per item
        double chocolatePrice = 3.0;
        double chipsPrice = 2.0;

        // Calculate total based on selection
        if (isChocolateSelected) {
            totalPrice += chocolatePrice * quantity;  // Chocolate price
        }
        if (isChipsSelected) {
            totalPrice += chipsPrice * quantity;  // Chips price
        }

        return totalPrice;  // Return the calculated total price
    }
}
