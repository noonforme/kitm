package org.example;

public interface Discountable {
    void applyDiscount(double discount);
    void applyBulkDiscount(int qty, double discount);
}