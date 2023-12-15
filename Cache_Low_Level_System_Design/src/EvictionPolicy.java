public interface EvictionPolicy<Key> {
    void keyAccessed(Key k);

    void remove(Key k);

    Key evict();

}
