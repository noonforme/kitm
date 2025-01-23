package org.example;

import java.util.*;

public class Store {
    private final Map<String, InventoryItem> inventory;
    private final List<Cart> carts;
    private final Map<Category, List<Product>> aisleInventory;

    public Store() {
        this.inventory = new HashMap<>();
        this.carts = new ArrayList<>();
        this.aisleInventory = new HashMap<>();
    }

    public void addInventoryItem(InventoryItem item) {
        inventory.put(item.getProduct().getSku(), item);
        aisleInventory.computeIfAbsent(item.getProduct().getCategory(), k -> new ArrayList<>()).add(item.getProduct());
    }

    public void addCart(Cart cart) {
        carts.add(cart);
    }

    public void manageStoreCarts() {
        carts.forEach(cart -> System.out.println("Managing: " + cart.getId()));
    }

    public void checkOutCart(String cartId) {
        Optional<Cart> cartOpt = carts.stream().filter(cart -> cart.getId().equals(cartId)).findFirst();
        if (cartOpt.isPresent()) {
            Cart cart = cartOpt.get();
            cart.printSalesSlip();
            cart.getProducts().forEach((product, qty) -> {
                InventoryItem item = inventory.get(product.getSku());
                if (item != null) {
                    item.sellItem(qty);
                }
            });
            carts.remove(cart);
            System.out.println("Checked out: " + cartId);
        } else {
            System.out.println("Cart: " + cartId + " not found.");
        }
    }

    public void abandonCarts(Date currentDate) {
        carts.removeIf(cart -> !cart.getDate().equals(currentDate));
        System.out.println("Old cart GONE! Destroyed!");
    }

    public void listProductsByCategory(Category category) {
        List<Product> products = aisleInventory.getOrDefault(category, Collections.emptyList());
        System.out.println("Found products in category: " + category + ":");
        products.forEach(System.out::println);
    }

    public Map<String, InventoryItem> getInventory() {
        return inventory;
    }
}
