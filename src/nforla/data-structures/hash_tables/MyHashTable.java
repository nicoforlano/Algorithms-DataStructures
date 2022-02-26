package hash_tables;

/**
 * Simple implementation of a custom Hashtable data structure.
 * Done as practice for a course on DataStructures and Algorithms.
 * This is not, by any means, a complete implementation of this data structure.
 * */
public class MyHashTable {

    private final int size;
    private final Bucket[] data;

    public MyHashTable(int size) {
        this.size = size;
        this.data = new Bucket[size];
    }

    public void set(String key, Object value) {
        if(key == null) {
            throw new RuntimeException("Key can't be null");
        }
        int index = this.hash(key);
        if(this.data[index] == null) {
            this.data[index] = new Bucket();
        }
        this.data[index].add(key, value);
    }

    public Object get(String key) {
        if(key == null) {
            return null;
        }
        int index = this.hash(key);
        Bucket bucket = this.data[index];
        if(bucket == null) {
            return null;
        }
        return bucket.get(key)[1];
    }

    private int hash(String key) {
        int hash = 0;
        for (int i=0; i < key.length(); i++) {
            hash = (hash + key.codePointAt(i) * i) % this.size;
        }
        return hash;
    }

    public static void main(String[] args) {
        MyHashTable hashTable = new MyHashTable(2);
        hashTable.set("key", 123);
        hashTable.set("asd", "asds");
        hashTable.set("anotherKey", null);
        System.out.println(hashTable.get("key"));
        System.out.println(hashTable.get("asd"));
        System.out.println(hashTable.get(null));
    }
}
