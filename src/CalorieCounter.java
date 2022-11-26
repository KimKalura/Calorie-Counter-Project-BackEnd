import java.util.Scanner;

public class CalorieCounter {

    public static void main(String[] args) {
        int selection = 0;
        ProductCatalog productCatalog = new ProductCatalog();
        Scanner console = new Scanner(System.in);
        do {
            printMenu();
            selection = console.nextInt();
            performSelectedAction(selection, productCatalog);

        } while (selection != 6);
    }

    public static void addProduct(ProductCatalog productCatalog) {
        Scanner console = new Scanner(System.in);
        System.out.println("Enter the product details:");
        System.out.print("Name: ");
        String name = console.nextLine();
        System.out.print("Fats: ");
        int fats = console.nextInt();
        System.out.print("Carbohydrates: ");
        int carbohydrates = console.nextInt();
        System.out.print("Proteins: ");
        int proteins = console.nextInt();
        boolean result = productCatalog.addProduct(new Product(name, fats, carbohydrates, proteins));
        if (!result) {
            System.out.println("The catalog is full or the product already exists.");
        } else {
            System.out.println("The product has been successfully added!");
        }

    }

    public static void computeCalories() {
        Scanner console = new Scanner(System.in);
        System.out.println("Enter the product details:");
        System.out.print("Fats: ");
        int fats = console.nextInt();
        System.out.print("Carbohydrates: ");
        int carbohydrates = console.nextInt();
        System.out.print("Proteins: ");
        int proteins = console.nextInt();
        int kcal = Product.computeCalories(fats, carbohydrates, proteins);
        System.out.println("The product has: " + kcal + " kcal");
    }

    public static void deleteProduct(ProductCatalog productCatalog) {
        Scanner console = new Scanner(System.in);
        System.out.println("Enter the name of the product you want to delete:");
        System.out.print("Name: ");
        String name = console.nextLine();
        if (!productCatalog.deleteProduct(name)) {
            System.out.println("The product: " + name + " does not exist!");
        } else {
            System.out.println("The product has been successfully deleted!");
        }
    }

    public static void getProduct(ProductCatalog productCatalog) {
        Scanner console = new Scanner(System.in);
        System.out.println("Enter the name of the product you are looking for:");
        System.out.print("Name: ");
        String name = console.nextLine();
        Product productFound = productCatalog.findProductByName(name);
        if (productFound == null) {
            System.out.println("The product: " + name + " does not exist");
        } else {
            System.out.println(productFound);
        }
    } 

    public static void performSelectedAction(int selection, ProductCatalog productCatalog) {
        switch (selection) {
            case 1:
                addProduct(productCatalog);
                break;
            case 2:
                computeCalories();
                break;
            case 3:
                productCatalog.printProducts();
                break;
            case 4:
                deleteProduct(productCatalog);
                break;
            case 5:
                getProduct(productCatalog);
                break;
            case 6:
                System.out.println("EXIT");
                break;
            default:
                System.out.println("The entered option does not exist");
        }
    }

    public static void printMenu() {
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("MENU: ");
        System.out.println("1. Add a product to the catalog and calculate its calories");
        System.out.println("2. Calculate the calories for a product without being added to the catalog");
        System.out.println("3. Show all the products in the catalog and the calories for each one");
        System.out.println("4. Delete a product from the catalog");
        System.out.println("5. Find product by name");
        System.out.println("6. Exit the application");
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("Enter an option:");
    }
}

