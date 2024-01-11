import java.util.LinkedList;

public class ProductTable {
    private LinkedList<Product>[] table;
    public ProductTable() {
        this(10);
    }
    public ProductTable(int initialCapacity) {
        table = new LinkedList[initialCapacity];
    }


    public void addProduct(Product product) {
        int index = hash(product.getID());
        if (table[index] == null) {
            table[index] = new LinkedList<>();
        }
        table[index].addLast(product);
    }

    public Product findProduct(int ID) {
        int index = hash(ID);
        if (table[index] != null) {
            for (Product product : table[index]) {
                if (product.getID()==ID) {
                    return product;
                }
            }
        }
        return null;
    }

    public void removeProduct(int ID) {
        int index = hash(ID);
        if (table[index] != null) {
            LinkedList<Product> list = table[index];
            for (Product product : list) {
                if (product.getID()==ID) {
                    list.remove(product);
                    return;
                }
            }
        }
    }

    private int hash(int ID) {
        int index = ID * 31 % table.length;
        return (index < 0) ? index + table.length : index;
    }
}
