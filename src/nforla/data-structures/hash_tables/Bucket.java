package hash_tables;

import java.util.ArrayList;
import java.util.List;

public class Bucket {

    private final List<Object[]> bucketData;

    public Bucket() {
        bucketData = new ArrayList<>();
    }

    public void add(String key, Object value) {
        bucketData.add(new Object[]{key, value});
    }

    public Object[] get(String key) {
        for (Object[] element : bucketData) {
            if(element[0] == key) {
                return element;
            }
        }
        return null;
    }
}
