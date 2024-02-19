public class ThreadSafeLinkedList<T> {

    private Node<T> head = new Node<T>(null);
    private Node<T> tail = new Node<T>(null);

    private Object lock1 = new Object();

    private Object lock2 = new Object();

    public ThreadSafeLinkedList() {
        head.setNext(tail);
    }

    public void insertNode(Node<T> node) {
        synchronized (lock2) {
            node.setNext(head.getNext());
            head.setNext(node);
        }
    }

    public boolean isEmpty() {
        return head.getNext() == tail;
    }

    public Node<T> popFromFront() {
        synchronized (lock1) {
            if(isEmpty()) {
                throw new LinkedListEmptyException();
            }
            Node nextNode = head.getNext().getNext();
            Node nodeToBePopped = head.getNext();
            head.setNext(nextNode);
            return nodeToBePopped;
        }
    }

}