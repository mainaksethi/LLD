public class DoublyLinkedList<Key> {

    DoublyLinkedListNode<Key> head = new DoublyLinkedListNode<>(null);
    DoublyLinkedListNode<Key> tail = new DoublyLinkedListNode<>(null);

    public void DoublyLinkedList() {
        this.head = head;
        this.tail = tail;
        head.next = tail;
    }

    public void addNodeToLast(DoublyLinkedListNode dllNode) {
        tail.prev.next = dllNode;
        dllNode.next = tail;
    }

    public void remove(DoublyLinkedListNode dllNode) {
        dllNode.prev.next = dllNode.next;
        dllNode.prev = null;
        dllNode.next = null;
    }

    public DoublyLinkedListNode<Key> tail() {
        if (tail.prev == head) {
            return null;
        }
        return tail.prev;
    }

}
