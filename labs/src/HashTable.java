import java.util.LinkedList;

public class HashTable<K, V> {
    private LinkedList<Entry<K, V>>[] table;
    private int size;

    public HashTable() {
        this(10);
    }

    public HashTable(int initialCapacity) {
        table = new LinkedList[initialCapacity];
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void put(K key, V value) {
        int index = hash(key);
        if (table[index] == null) {
            table[index] = new LinkedList<Entry<K, V>>();
        }

        LinkedList<Entry<K, V>> list = table[index];
        for (Entry<K, V> entry : list) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
        }

        list.addFirst(new Entry<K, V>(key, value));
        size++;
    }


    public V get(K key) {
        int index = hash(key);
        if (table[index] != null) {
            for (Entry<K, V> entry : table[index]) {
                if (entry.getKey().equals(key)) {
                    return entry.getValue();
                }
            }
        }
        return null;
    }

    public void remove(K key) {
        int index = hash(key);
        if (table[index] != null) {
            LinkedList<Entry<K, V>> list = table[index];
            for (Entry<K, V> entry : list) {
                if (entry.getKey().equals(key)) {
                    list.remove(entry);
                    size--;
                    return;
                }
            }
        }
    }

    private int hash(K key) {
        int index = key.hashCode() % table.length;
        return (index < 0) ? index + table.length : index;
    }

    private static class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        HashTable<String, Integer> hashMap = new HashTable<>();

        hashMap.put("a", 5);
        hashMap.put("b", 5);
        hashMap.put("c", 7);

        System.out.println(hashMap.get("a"));
        System.out.println(hashMap.get("b"));
        System.out.println(hashMap.get("c"));

        hashMap.remove("b");
        System.out.println(hashMap.get("b"));

        System.out.println(hashMap.size());
        System.out.println(hashMap.isEmpty());
    }
}