public class CacheFactory {

    public static Cache<Integer, Integer> get() {
        return new Cache<Integer, Integer>(
                new HashMapBasedStorage<Integer, Integer>(10),
                new LRUBasedEvictionPolicy<Integer, Integer>());
    }
}
