public class Cache<Key, Value> {

    private Storage<Key, Value> storage;
    private EvictionPolicy<Key> evictionPolicy;

    public Cache(Storage<Key, Value> storage, EvictionPolicy<Key> evictionPolicy) {
        this.storage = storage;
        this.evictionPolicy = evictionPolicy;
    }

    public Value get(Key key) {
        Value v = storage.get(key);
        evictionPolicy.keyAccessed(key);
        return v;
    }

    public void remove(Key key) {
        storage.remove(key);
        evictionPolicy.remove(key);
    }

    public void insert(Key key, Value value) {
        try {
            storage.insert(key, value);
            evictionPolicy.keyAccessed(key);
        } catch (StorageFullException storageFullException) {
            Key k = evictionPolicy.evict();
            storage.remove(k);
            storage.insert(key, value);
            evictionPolicy.keyAccessed(key);
        }
    }
}
