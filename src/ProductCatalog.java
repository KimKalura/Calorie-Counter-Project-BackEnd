public class ProductCatalog {
    Product[] products;
    int noOfProductsAdded;

    public ProductCatalog() {
        products = new Product[100];
        noOfProductsAdded = 0;
    }

    public void printProducts() {
        if (noOfProductsAdded == 0) {
            System.out.println("There are no products in the catalog");
            return;
        }
        for (int i = 0; i < noOfProductsAdded; i++) {
            System.out.println(i + 1 + ". Product: " + products[i]);
        }
    }

    public boolean addProduct(Product product) {
        if (noOfProductsAdded == 100) {
            return false;
        }
        int index = getProductIndex(product.name);
        if (index != -1) {
            return false;
        }
        products[noOfProductsAdded++] = product;
        return true;
    }


    public boolean deleteProduct(String productName) {
        int productIndex = getProductIndex(productName);
        if (productIndex == -1) {
            return false;
        }
        for (int i = productIndex; i < noOfProductsAdded; i++) {
            products[i] = products[i + 1];
        }
        products[noOfProductsAdded] = null;
        noOfProductsAdded--;
        return true;
    }

    public Product findProductByName(String productName) {
        int index = getProductIndex(productName);
        if (index == -1) {
            return null;
        }
        return products[index];
    }

    private int getProductIndex(String productName) {
        for (int i = 0; i < noOfProductsAdded; i++) {
            if (products[i].name.equals(productName)) {
                return i;
            }
        }
        return -1;
    }
}