public class Market {
    public static void main(String[] args) {
        ProductTable productTable = new ProductTable();
        Product product1 = new Product(1, "first", "first product", 1,10);
        Product product2 = new Product(2, "second", "second product", 2,20);
        productTable.addProduct(product1);
        productTable.addProduct(product2);
        Product foundProduct = productTable.findProduct(1);
        if (foundProduct != null) {
            System.out.println("Name: " + foundProduct.getName());
        } else {
            System.out.println("This product doesn't exist.");
        }
        productTable.removeProduct(2);
        System.out.println(productTable.findProduct(2));
    }
}
