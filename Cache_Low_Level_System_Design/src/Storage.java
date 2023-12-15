public interface Storage<Key, Value> {

    Value get(Key key);

    void remove(Key key);

    void insert(Key key, Value value);

}
