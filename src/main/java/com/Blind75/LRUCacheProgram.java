package com.Blind75;

import java.util.*;

public class LRUCacheProgram {
    public static void main(String... args) {
        //usingLinkedHashMap();
        usingDLLandHashing();
    }

    //Expected Implementation using DoublyLinkedList and Hashing
    public static void usingDLLandHashing() {
        LRUCacheDLL lRUCache = new LRUCacheDLL(2);
        lRUCache.showDLL();
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.showDLL();
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        lRUCache.showDLL();
        lRUCache.get(1);    // return 1
        lRUCache.showDLL();
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        lRUCache.showDLL();
        lRUCache.get(2);    // returns -1 (not found)
        lRUCache.showDLL();
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        lRUCache.showDLL();
        lRUCache.get(1);    // return -1 (not found)
        lRUCache.showDLL();
        lRUCache.get(3);    // return 3
        lRUCache.showDLL();
        lRUCache.get(4);    // return 4
        lRUCache.showDLL();
    }

    public static class LRUCacheDLL {
        private int capacity;
        Map<Integer, Node> map;
        Node head, tail;

        public LRUCacheDLL(int capacity) {
            this.capacity = capacity;
            map = new HashMap<>();
            this.head = new Node(-1, -1);
            this.tail = new Node(-1, -1);
            this.head.next = tail;
            this.tail.previos = this.head;
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }

            Node node = map.get(key);
            removeNode(node);
            addNode(node);
            return node.value;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                Node temp = map.get(key);
                removeNode(temp);
            }
            Node temp = new Node(key, value);
            addNode(temp);
            map.put(key, temp);
            if (map.size() > capacity) {
                map.remove(tail.previos.key);
                removeNode(tail.previos);

            }
        }

        void addNode(Node node) {
            Node nextNode = head.next;
            head.next = node;
            node.previos = head;
            node.next = nextNode;
            nextNode.previos = node;
        }

        void removeNode(Node node) {
            Node nextNode = node.next;
            Node prevNode = node.previos;
            prevNode.next = nextNode;
            nextNode.previos = prevNode;
        }

        void showDLL() {
            Node temp = head;
            System.out.println("=== Start ===");
            while (temp != null) {
                System.out.print(" | Key : " + temp.key + " | Value : " + temp.value);
                temp = temp.next;
            }
            System.out.println();
            System.out.println("=== End ===");
        }
    }

    static class Node {
        int key;
        int value;
        Node previos;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = key;
        }
    }


    //Lazy Implementation using LinkedHashMap
    public static void usingLinkedHashMap() {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        lRUCache.get(1);    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        lRUCache.get(2);    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        lRUCache.get(1);    // return -1 (not found)
        lRUCache.get(3);    // return 3
        lRUCache.get(4);    // return 4

    }

    static class LRUCache {
        private final int capacity;
        private LinkedHashMap<Integer, Integer> map;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new LinkedHashMap<>(capacity, 1.0f, true) {
                @Override
                protected boolean removeEldestEntry(Map.Entry entry) {
                    return this.size() > capacity;
                }
            };
        }

        public int get(int key) {
            return map.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            map.put(key, value);
        }
    }
}
