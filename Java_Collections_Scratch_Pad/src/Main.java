import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        // List
        // Array-List
        List<Integer> list = new ArrayList();
        list.add(10);
        list.add(20);
        list.add(30);
        // Iterate over Array List
        System.out.println("Iterating over Array List: \n");
        for (Integer val: list) {
            System.out.println(val + ",");
        }
        System.out.println("Array-List element at index 2: " + list.get(2));
        System.out.println("Array-List contains 20: " + list.contains(20));
        System.out.println("Array-List index of element with value 20: " + list.indexOf(20));
        System.out.println("Array-List remove element at index 2: " + list.remove(2));
        // Queue
        // Priority Queue, Default Min-Heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(30);
        pq.add(10);
        System.out.println("Heaps top element: " + pq.peek());
        pq.poll();
        System.out.println("Heaps top element after removing 10: " + pq.peek());
        // Linked-List
        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(1);
        ll.add(2);
        System.out.println("Linked List First Element: " + ll.getFirst());
        System.out.println("Linked List Last Element: " + ll.getLast());
        ll.poll();
        System.out.println("Linked List Last Element after removing first element: " + ll.getFirst());
        // Set
        // HashSet
        Set<Integer> hashSet = new HashSet<>();
        hashSet.add(10);
        hashSet.add(20);
        hashSet.add(10);
        System.out.println("Iterating over Hash Set: \n");
        for (Integer val: hashSet) {
            System.out.println(val + ",");
        }
        System.out.println("Size of set: " + hashSet.size());
        System.out.println("Set contains 10: " + hashSet.contains(10));
        System.out.println("Set contains 30: " + hashSet.contains(30));
        System.out.println("Set remnove 10: " + hashSet.remove(10));
        // TreeSet => Ordered Set
        Set<Integer> treeSet = new TreeSet<>();
        treeSet.add(10);
        treeSet.add(20);
        treeSet.add(10);
        System.out.println("Size of set: " + treeSet.size());
        System.out.println("Set contains 10: " + treeSet.contains(10));
        System.out.println("Set contains 30: " + treeSet.contains(30));
        System.out.println("Set remnove 10: " + treeSet.remove(10));
        // LinkedHashSet => Set elements in insertion order
        Set<Integer> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(10);
        linkedHashSet.add(20);
        linkedHashSet.add(10);
        System.out.println("Size of set: " + linkedHashSet.size());
        System.out.println("Set contains 10: " + linkedHashSet.contains(10));
        System.out.println("Set contains 30: " + linkedHashSet.contains(30));
        System.out.println("Set remnove 10: " + linkedHashSet.remove(10));
        // Hash-Map
        Map<Integer, Integer> hashMap = new HashMap();
        hashMap.put(10, 100);
        hashMap.put(20, 200);
        hashMap.put(30, 300);
        System.out.println("Iterating over Hash Map: \n");
        for (Map.Entry<Integer, Integer> entry: hashMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("Value at 10: " + hashMap.get(10));
        hashMap.put(10, 400);
        System.out.println("Updated Value at 10: " + hashMap.get(10));
        System.out.println("Value at non-existing key 40: " + hashMap.get(40));
        // Ordered-Map
        Map<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(10, 100);
        treeMap.put(20, 200);
        treeMap.put(30, 300);
        System.out.println("Iterating over Tree Map: \n");
        for (Map.Entry<Integer, Integer> entry: treeMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("Value at 10: " + treeMap.get(10));
        treeMap.put(10, 400);
        System.out.println("Updated Value at 10: " + treeMap.get(10));
        System.out.println("Value at non-existing key 40: " + treeMap.get(40));
    }
}