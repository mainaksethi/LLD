import java.util.*;

class Node  {
    Integer val;

    public Node(Integer val) {
        this.val = val;
    }

    @Override
    public boolean equals(Object obj) {
        return ((Node)obj).val.equals(this.val);
    }

    @Override
    public int hashCode() {
        return this.val;
    }
}

class Scratch {
    public static void main(String[] args) {

        // C++ priority_queue => java priority_queue
        // Priority Queue with custom comparator
        // By default min_heap

        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.val.equals(o2.val)) {
                    return 0;
                }
                return o1.val > o2.val ? -1 : 1;
            }
        });
        pq.add(new Node(2));
        pq.add(new Node(1));

        // Uses custom comparator for key fetching.
        System.out.println("Fist Value in priority-queue = " + pq.peek().val);

        // C++ map => java treemap
        // TreeMap with custom comparator

        TreeMap<Node, Integer> mp = new TreeMap<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.val.equals(o2.val)) {
                    return 0;
                }
                return o1.val > o2.val ? -1 : 1;
            }
        });
        mp.put(new Node(1), 10);
        mp.put(new Node(4), 10);
        // Now, fetching the value using a Node with the same value
        Node keyToFind = new Node(1);
        Integer value = mp.get(keyToFind);

        // iteration over treeMap.
        System.out.println("Iterating over tree-map");
        for (Map.Entry<Node, Integer> entry: mp.entrySet()) {
            System.out.println(entry.getKey().val + ", " + entry.getValue());
        }

        // Note since our map is reversed its printing reverse entries.
        // Note in C++
        // lower_bound = first value greater than or equal to
        // upper_bound = first value greater than.

        // Key greater than or equal to value.
        System.out.println("Printing upper bound for treemap with key(3): " + mp.ceilingEntry(new Node(3)).toString());

        // Key less than or equal to value.
        System.out.println("Printing lower bound for treemap with key(3): " + mp.floorEntry(new Node(3)).toString());

        // Uses custom comparator for key fetching.
        System.out.println("Value corresponding to Node(1) in treeMap: " + value);

        // C++ unordered_map => Java hash_map

        HashMap<Node, Integer> hashMap = new HashMap<>();

        hashMap.put(new Node(1), 100);
        hashMap.put(new Node(2), 200);

        // Uses hash-code and equals for key fetching.
        System.out.println("Value corresponding to Node(1) in hashMap: " + hashMap.get(new Node(1)));

        System.out.println("Iterating over hash-map");
        for (Map.Entry<Node, Integer> entry: hashMap.entrySet()) {
            System.out.println(entry.getKey().val + ", " + entry.getValue());
        }

    }
}