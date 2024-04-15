import java.util.*;

class DSNode {
    Integer val;

    public DSNode(Integer val) {
        this.val = val;
    }

    @Override
    public boolean equals(Object obj) {
        return ((DSNode)obj).val.equals(this.val);
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

        PriorityQueue<DSNode> pq = new PriorityQueue<>(new Comparator<DSNode>() {
            @Override
            public int compare(DSNode o1, DSNode o2) {
                if (o1.val.equals(o2.val)) {
                    return 0;
                }
                return o1.val > o2.val ? -1 : 1;
            }
        });
        pq.add(new DSNode(2));
        pq.add(new DSNode(1));

        // Uses custom comparator for key fetching.
        System.out.println("Fist Value in priority-queue = " + pq.peek().val);

        // C++ map => java treemap
        // TreeMap with custom comparator

        TreeMap<DSNode, Integer> mp = new TreeMap<>(new Comparator<DSNode>() {
            @Override
            public int compare(DSNode o1, DSNode o2) {
                if (o1.val.equals(o2.val)) {
                    return 0;
                }
                return o1.val > o2.val ? -1 : 1;
            }
        });
        mp.put(new DSNode(1), 10);
        mp.put(new DSNode(4), 10);
        // Now, fetching the value using a Node with the same value
        DSNode keyToFind = new DSNode(1);
        Integer value = mp.get(keyToFind);

        // iteration over treeMap.
        System.out.println("Iterating over tree-map");
        for (Map.Entry<DSNode, Integer> entry: mp.entrySet()) {
            System.out.println(entry.getKey().val + ", " + entry.getValue());
        }

        // Note since our map is reversed its printing reverse entries.
        // Note in C++
        // lower_bound = first value greater than or equal to
        // upper_bound = first value greater than.

        // Key greater than or equal to value.
        System.out.println("Printing upper bound for treemap with key(3): " + mp.ceilingEntry(new DSNode(3)).toString());

        // Key less than or equal to value.
        System.out.println("Printing lower bound for treemap with key(3): " + mp.floorEntry(new DSNode(3)).toString());

        // Uses custom comparator for key fetching.
        System.out.println("Value corresponding to Node(1) in treeMap: " + value);

        // C++ unordered_map => Java hash_map

        HashMap<DSNode, Integer> hashMap = new HashMap<>();

        hashMap.put(new DSNode(1), 100);
        hashMap.put(new DSNode(2), 200);

        // Uses hash-code and equals for key fetching.
        System.out.println("Value corresponding to Node(1) in hashMap: " + hashMap.get(new DSNode(1)));

        System.out.println("Iterating over hash-map");
        for (Map.Entry<DSNode, Integer> entry: hashMap.entrySet()) {
            System.out.println(entry.getKey().val + ", " + entry.getValue());
        }

        // C++ unordered_set => Java hash_set

        HashSet<DSNode> hashSet = new HashSet<>();

        hashSet.add(new DSNode(1));
        hashSet.add(new DSNode(2));

        // Uses hash-code and equals for key fetching.
        System.out.println("Node(1) present in hashSet: " + hashSet.contains(new DSNode(1)));

        System.out.println("Iterating over hash-set");
        for (DSNode n: hashSet) {
            System.out.println(n.val);
        }

        // C++ set => Java tree_set

        TreeSet<DSNode> treeSet = new TreeSet<>(new Comparator<DSNode>() {
            @Override
            public int compare(DSNode o1, DSNode o2) {
                if (o1.val == o2.val) {
                    return 0;
                }
                return o1.val > o2.val ? 1 : -1;

            }
        });

        treeSet.add(new DSNode(1));
        treeSet.add(new DSNode(4));

        // Uses hash-code and equals for key fetching.
        System.out.println("First node of treeset " + treeSet.first());

        // lower for key less than given key.
        System.out.println("Node lower than Node(3) " + treeSet.lower(new DSNode(3)));

        // Note it doesn't return equals.
        System.out.println("Node lower than Node(1) " + treeSet.lower(new DSNode(1)));

        // higher for key greater than given key
        System.out.println("Node higher than Node(3) " + treeSet.higher(new DSNode(3)));

        System.out.println("Iterating over tree-set");
        for (DSNode n: treeSet) {
            System.out.println(n.val);
        }

        // C++ vector => Java ArrayList

        ArrayList<DSNode> arrayList = new ArrayList<>();

        for (int i = 10; i < 40; i = i + 10) {
            arrayList.add(new DSNode(i));
        }

        System.out.println("Printing 2nd value of array-list: " + arrayList.get(1).val);

        System.out.println("Iterating over array list: ");
        for (DSNode node: arrayList) {
            System.out.println(node.val + ", ");
        }

        // Reverse Sorting Array List

        arrayList.sort(new Comparator<DSNode>() {
            @Override
            public int compare(DSNode o1, DSNode o2) {
                if (o1.val == o2.val) {
                    return 0;
                }
                return o1.val > o2.val ? -1 : 1;
            }
        });

        System.out.println("Printing reverse sorted array list: ");
        for (DSNode node: arrayList) {
            System.out.println(node.val + ", ");
        }

        // Cloning Array-List
        ArrayList<DSNode> clonedArrayList = (ArrayList<DSNode>) arrayList.clone();

        System.out.println("Printing cloned array list: ");
        for (DSNode node: clonedArrayList) {
            System.out.println(node.val + ", ");
        }

        // C++ 2-d vector to 2-d arraylist

        ArrayList<ArrayList<Integer>> twoDArrayList = new ArrayList<ArrayList<Integer>>();

        for (Integer i = 0; i < 4; i++) {
            twoDArrayList.add(new ArrayList<>());
            ArrayList<Integer> row = twoDArrayList.get(i);
            for (Integer j = 0; j < 4; j++) {
                Integer val = i*10 + j;
                row.add(val);
            }
        }

        // Java printing 2-d array-list
        System.out.println("Printing two-d array-list.");
        for (Integer i = 0; i < twoDArrayList.size(); i++) {
            for (Integer j = 0; j < twoDArrayList.get(i).size(); j++) {
                System.out.print(twoDArrayList.get(i).get(j) + ",");
            }
            System.out.println();
        }

        // C++ String => Java String

        String s = new String("mainak");

        // sorting a string

        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);

        String sortedString = new String(charArray);

        System.out.println("Printing sorted string: " + sortedString);

        // C++ dequeue => Java deque
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(10);
        deque.addLast(20);
        deque.addLast(30);
        System.out.println("Printing Deque Values: \n");
        for (Integer val: deque) {
            System.out.print(val + ",");
        }
        System.out.println();
        System.out.println("Dequeue Front: " + deque.peekFirst());
        deque.pollFirst();
        System.out.println("Dequeue Front after popping first element: " + deque.peekFirst());
        System.out.println("Dequeue Last: " + deque.peekLast());
        deque.pollLast();
        System.out.println("Dequeue Last after popping last element: " + deque.peekLast());
        deque.addFirst(0);
        System.out.println("Dequeue Inserting element at the beginning: " + deque.peekFirst());
    }
}