import java.util.HashMap;
import java.util.Map;

public class HashMapBasedStorage<Key, Value> implements Storage<Key, Value> {

    Map<Key, Value> hashMap = new HashMap<>();

    private Integer capacity;

    public HashMapBasedStorage(Integer capacity) {
        this.capacity = capacity;
    }

    @Override
    public Value get(Key key) {
        return hashMap.get(key);
    }

    @Override
    public void remove(Key key) {
        hashMap.remove(key);
    }

    @Override
    public void insert(Key key, Value value) {
        if (hashMap.keySet().size() == capacity) {
            throw new StorageFullException();
        }
        hashMap.put(key, value);
    }
}
