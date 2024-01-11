import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.*;


public class Warehouse {

    public static void main(String[] args) {
        final int LOADERS = 1;
        List<Item> warehouse = new ArrayList<>();
        warehouse.add(new Item("Product 1", 30));
        warehouse.add(new Item("Product 2", 40));
        warehouse.add(new Item("Product 3", 25));
        warehouse.add(new Item("Product 4", 35));
        warehouse.add(new Item("Product 5", 20));
        warehouse.add(new Item("Product 6", 70));
        warehouse.add(new Item("Product 7", 60));
        warehouse.add(new Item("Product 8", 50));
        warehouse.add(new Item("Product 9", 30));
        warehouse.add(new Item("Product 10", 40));
        warehouse.add(new Item("Product 11", 45555554));


        ExecutorService executor = Executors.newFixedThreadPool(LOADERS);
        try {
            while (!warehouse.isEmpty()) {
                List<Item> loadingItems = new ArrayList<>();
                int totalWeight = 0;
                Iterator<Item> iterator = warehouse.iterator();
                while (iterator.hasNext()) {
                    Item item = iterator.next();
                    if (item.getWeight() > 150) {
                        System.out.println("Item " + item.getName() + " is too heavy for the loaders to deliver.");
                        iterator.remove();
                    } else if (totalWeight + item.getWeight() <= 150) {
                        loadingItems.add(item);
                        totalWeight += item.getWeight();
                        iterator.remove();
                    }
                }
                executor.execute(new LoaderRealization(loadingItems));
            }
        } finally {
            executor.shutdown();
        }
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            System.out.println("Threads were interrupted.");
        }
    }


}

interface Loader {
    void loadItems(List<Item> items);
}
class LoaderRealization implements Loader, Runnable {
    private List<Item> items;
    public LoaderRealization(List<Item> items) {
        this.items = items;
    }

    @Override
    public void loadItems(List<Item> items) {
        List<String> itemNames = new ArrayList<>();
        for (Item item : items) {
            itemNames.add(item.getName());
        }
        System.out.println("Loading items: " + itemNames);
    }
    public void carryItems(List<Item> items){
        List<String> itemNames = new ArrayList<>();
        for (Item item : items) {
            itemNames.add(item.getName());
        }
        System.out.println("Carried items: " + itemNames);
    }
    @Override
    public void run() {
        loadItems(items);
        carryItems(items);
//        for (Item item : items) {
//            System.out.println("Loader carried " + item.getName());
//        }
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}

class Item {
    private String name;
    private int weight;

    public Item(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }
}