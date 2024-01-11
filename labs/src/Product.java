public class Product {
    private int ID;
    private String name;
    private String description;
    private int price;
    private int amount;

    public Product(int ID, String name, String description, int price, int amount) {
        this.ID=ID;
        this.name = name;
        this.description = description;
        this.price = price;
        this.amount = amount;
    }
    public int getID(){
        return ID;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }
    public int getAmount(){
        return amount;
    }

}