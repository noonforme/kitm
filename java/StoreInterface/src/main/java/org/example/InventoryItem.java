package org.example;

public class InventoryItem {
    private final Product product;
    private int qtyTotal;
    private int qtyReserved;
    private int qtyReorder;
    private int qtyLow;
    private double salesPrice;

    public InventoryItem(Product product, int qtyTotal, int qtyReorder, int qtyLow, double salesPrice) {
        this.product = product;
        this.qtyTotal = qtyTotal;
        this.qtyReserved = 0;
        this.qtyReorder = qtyReorder;
        this.qtyLow = qtyLow;
        this.salesPrice = salesPrice;
    }

    public Product getProduct() {
        return product;
    }

    public int getQtyTotal() {
        return qtyTotal;
    }

    public int getQtyReserved() {
        return qtyReserved;
    }

    public int getQtyReorder() {
        return qtyReorder;
    }

    public int getQtyLow() {
        return qtyLow;
    }

    public double getSalesPrice() {
        return salesPrice;
    }

    public int getAvailableQty() {
        return qtyTotal - qtyReserved;
    }

    public void reserveItem(int qty) {
        if (qty <= getAvailableQty()) {
            qtyReserved += qty;
        } else {
            System.out.println("Not enough available qty. RESERVERORDER");
        }
    }

    public void releaseItem(int qty) {
        if (qty <= qtyReserved) {
            qtyReserved -= qty;
        } else {
            System.out.println("Not enough available qty. RELEASEORDER");
        }
    }

    public void sellItem(int qty) {
        if (qty <= getAvailableQty()) {
            qtyTotal -= qty;
        } else {
            System.out.println("Not enough available qty. SELLORDER");
        }
    }

    public void placeInventoryOrder() {
        qtyTotal += qtyReorder;
    }

}
