import java.util.*;

// тупая хеш-мапа 
/* TABLE_SIZE в 3 раза больше по условию задачи, 
чтобы при вычислении хеша чаще получались разные числа 
и по 1 хешу было не слишком много пар*/ 
public class HashMapImpl<V> implements HashMap<String, V> {

    private static final int TABLE_SIZE = 300003;
    private static final int A = 31; // так принято вроде (простое число это круто меньше коллизий)
    private List<List<String[]>> table = new ArrayList<>();

    public HashMapImpl() {
        for (int i = 0; i < TABLE_SIZE; i++) {
            table.add(new ArrayList<>());
        }
    }

    private long hashByString(String value) {
        long hash = 0;
        for (int i = 0; i < value.length(); i++) {
            hash = (hash * A + value.charAt(i)) % TABLE_SIZE;
        }
        return hash;
    }

    @Override
    public void put(String key, V value) {
        List<String[]> bucket = table.get((int) hashByString(key));

        for (String[] pair : bucket) {
            if (pair[0].equals(key)) {
                pair[1] = (String) value;
                return;
            }
        }
        bucket.add(new String[] { key, (String) value });
    }

    @Override
    public V getValue(String key) {
        List<String[]> bucket = table.get((int) hashByString(key));

        for (String[] pair : bucket) {
            if (pair[0].equals(key)) {
                return (V) pair[1];
            }
        }
        return null;
    }

    @Override
    public V delete(String key) {
        List<String[]> bucket = table.get((int) hashByString(key));

        for (int i = 0; i < bucket.size(); i++) {
            if (bucket.get(i)[0].equals(key)) {
                return (V) bucket.remove(i)[1];
            }
        }
        return null;
    }
}