import java.util.ArrayList;
import java.util.Scanner;

abstract class Product {
    protected String name;
    protected double price;
    protected String category;

    public Product(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category.toLowerCase();
    }

    public abstract void displayInfo();
}

class Electronics extends Product {
    public Electronics(String name, double price) {
        super(name, price, "electronics");
    }

    @Override
    public void displayInfo() {
        System.out.printf("| %-20s | %-10.2f | %-15s |\n", name, price, category);
    }
}

class Food extends Product {
    public Food(String name, double price) {
        super(name, price, "food");
    }

    @Override
    public void displayInfo() {
        System.out.printf("| %-20s | %-10.2f | %-15s |\n", name, price, category);
    }
}

class Clothing extends Product {
    public Clothing(String name, double price) {
        super(name, price, "clothing");
    }

    @Override
    public void displayInfo() {
        System.out.printf("| %-20s | %-10.2f | %-15s |\n", name, price, category);
    }
}

class GenericProduct extends Product {
    public GenericProduct(String name, double price, String category) {
        super(name, price, category);
    }

    @Override
    public void displayInfo() {
        System.out.printf("| %-20s | %-10.2f | %-15s |\n", name, price, category);
    }
}

class Category {
    private String name;
    private ArrayList<Product> products;

    public Category(String name) {
        this.name = name.toLowerCase();
        this.products = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addProduct(Product product) {
        if (product.category.equals(this.name)) {
            products.add(product);
            System.out.println("Produktas pridėtas prie kategorijos: " + this.name);
        } else {
            System.out.printf("Klaida: Produkto kategorija yra '%s', bet kategorija nurodyta '%s'.\n", product.category, this.name);
        }
    }

    public void showProducts() {
        System.out.println("Kategorija: " + name.substring(0, 1).toUpperCase() + name.substring(1));
        System.out.println("===================================================================");
        System.out.println("| Pavadinimas          | Kaina      | Kategorija       |");
        System.out.println("===================================================================");
        for (Product product : products) {
            product.displayInfo();
        }
        System.out.println("===================================================================");
    }

    public ArrayList<Product> getProducts() {
        return products;
    }
}

class ProductManager {
    ArrayList<Category> categories;

    public ProductManager() {
        categories = new ArrayList<>();
    }

    public void addCategory(String categoryName) {
        categories.add(new Category(categoryName));
        System.out.println("Kategorija pridėta: " + categoryName);
    }

    public void addProductToCategory(String categoryName, Product product) {
        for (Category category : categories) {
            if (categoryName.toLowerCase().equals(category.getName())) {
                category.addProduct(product);
                return;
            }
        }
        System.out.println("Kategorija nerasta!");
    }

    public void searchProductByName(String productName) {
        for (Category category : categories) {
            for (Product product : category.getProducts()) {
                if (product.name.toLowerCase().contains(productName.toLowerCase())) {
                    product.displayInfo();
                }
            }
        }
    }

    public void showProductsByCategory(String categoryName) {
        for (Category category : categories) {
            if (categoryName.toLowerCase().equals(category.getName())) {
                category.showProducts();
                return;
            }
        }
        System.out.println("Kategorija nerasta!");
    }

    public void filterByPrice(double minPrice, double maxPrice) {
        for (Category category : categories) {
            for (Product product : category.getProducts()) {
                if (product.price >= minPrice && product.price <= maxPrice) {
                    product.displayInfo();
                }
            }
        }
    }

    public void sortProductsByPrice(boolean ascending) {
        ArrayList<Product> allProducts = new ArrayList<>();
        for (Category category : categories) {
            allProducts.addAll(category.getProducts());
        }

        allProducts.sort((p1, p2) -> ascending ? Double.compare(p1.price, p2.price) : Double.compare(p2.price, p1.price));

        for (Product product : allProducts) {
            product.displayInfo();
        }
    }

    public void showAllProducts() {
        for (Category category : categories) {
            category.showProducts();
        }
    }

    public void showCategories() {
        System.out.println("Galimos kategorijos:");
        for (Category category : categories) {
            System.out.println("- " + category.getName().substring(0, 1).toUpperCase() + category.getName().substring(1));
        }
    }
}

public class ppfp {
    public static void main(String[] args) {
        ProductManager manager = new ProductManager();
        Scanner scanner = new Scanner(System.in);

        manager.addCategory("Electronics");
        manager.addCategory("Food");
        manager.addCategory("Clothing");

        while (true) {
            System.out.println("\n1. Pridėti kategoriją");
            System.out.println("2. Pridėti prekę");
            System.out.println("3. Ieškoti prekių pagal pavadinimą");
            System.out.println("4. Filtruoti prekes pagal kategoriją");
            System.out.println("5. Filtruoti prekes pagal kainą");
            System.out.println("6. Rūšiuoti prekes pagal kainą");
            System.out.println("7. Rodyti visas prekes");
            System.out.println("8. Išeiti\n");
            System.out.print("Pasirinkite veiksmą: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Įveskite kategorija: ");
                    String catName = scanner.nextLine();
                    manager.addCategory(catName);
                    break;
                case 2:
                    manager.showCategories();
                    System.out.print("Įveskite kategorija: ");
                    String category = scanner.nextLine().toLowerCase();
                    System.out.print("Įveskite produkto pavadinimą: ");
                    String productName = scanner.nextLine();
                    System.out.print("Įveskite kainą: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();

                    boolean categoryExists = manager.categories.stream().anyMatch(c -> c.getName().equals(category));
                    if (!categoryExists) {
                        System.out.println("Netinkamas kategorijos pavadinimas.");
                        break;
                    }

                    Product product;
                    if (category.equals("electronics")) {
                        product = new Electronics(productName, price);
                    } else if (category.equals("food")) {
                        product = new Food(productName, price);
                    } else if (category.equals("clothing")) {
                        product = new Clothing(productName, price);
                    } else {
                        product = new GenericProduct(productName, price, category);
                    }

                    manager.addProductToCategory(category, product);
                    break;
                case 3:
                    System.out.print("Įveskite produkto vardą paieškai: ");
                    String searchName = scanner.nextLine();
                    manager.searchProductByName(searchName);
                    break;
                case 4:
                    System.out.print("Įveskite kategorijos vardą: ");
                    String categoryName = scanner.nextLine();
                    manager.showProductsByCategory(categoryName);
                    break;
                case 5:
                    System.out.print("Įveskite mažiausią kainą: ");
                    double minPrice = scanner.nextDouble();
                    System.out.print("Įveskite didžiausią kainą: ");
                    double maxPrice = scanner.nextDouble();
                    manager.filterByPrice(minPrice, maxPrice);
                    break;
                case 6:
                    System.out.print("Rūšiuoti didėjančia tvarka? (true/false): ");
                    boolean ascending = scanner.nextBoolean();
                    manager.sortProductsByPrice(ascending);
                    break;
                case 7:
                    manager.showAllProducts();
                    break;
                case 8:
                    System.out.println("Byeeeeeee!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Kažką maišai, bandyk dar kartą.");
            }
        }
    }
}
