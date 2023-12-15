public class DoublyLinkedListNode<Key> {

    private Key key;

    public DoublyLinkedListNode next = null;
    public DoublyLinkedListNode prev = null;

    public DoublyLinkedListNode(Key key) {
        this.key = key;
    }

    public Key getKey() {
        return key;
    }
}
