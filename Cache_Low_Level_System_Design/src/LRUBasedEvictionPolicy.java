import java.util.HashMap;
import java.util.Map;

public class LRUBasedEvictionPolicy<Key, Value> implements EvictionPolicy<Key> {

    DoublyLinkedList<Key> dll = new DoublyLinkedList();
    Map<Key, DoublyLinkedListNode<Key>> keyToNodeMap = new HashMap<Key, DoublyLinkedListNode<Key>>();

    @Override
    public void keyAccessed(Key k) {
        if (keyToNodeMap.get(k) != null) {
            DoublyLinkedListNode dllNode = keyToNodeMap.get(k);
            dll.remove(dllNode);
            dll.addNodeToLast(dllNode);
        } else {
            DoublyLinkedListNode dllNode = new DoublyLinkedListNode(k);
            dll.addNodeToLast(dllNode);
        }
    }

    @Override
    public void remove(Key k) {
        DoublyLinkedListNode dllNode = keyToNodeMap.get(k);
        dll.remove(dllNode);
        keyToNodeMap.remove(k);
    }

    @Override
    public Key evict() {
        DoublyLinkedListNode<Key> dllNode = dll.tail();
        dll.remove(dllNode);
        Key k = dllNode.getKey();
        keyToNodeMap.remove(k);
        return k;
    }
}
