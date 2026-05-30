package com.Blind75.LRUCache;

public class LRUCacheMapCaller {
    public static void main(String... args){
        LRUCacheMap<Integer,Integer> lRUCacheMap = new LRUCacheMap<>(2);
        System.out.println(lRUCacheMap);
        lRUCacheMap.put(1, 1); // cache is {1=1}
        System.out.println(lRUCacheMap);
        lRUCacheMap.put(2, 2); // cache is {1=1, 2=2}
        System.out.println(lRUCacheMap);
        lRUCacheMap.get(1);    // return 1
        System.out.println(lRUCacheMap);
        lRUCacheMap.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        System.out.println(lRUCacheMap);
        lRUCacheMap.get(2);    // returns -1 (not found)
        System.out.println(lRUCacheMap);
        lRUCacheMap.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        System.out.println(lRUCacheMap);
        lRUCacheMap.get(1);    // return -1 (not found)
        System.out.println(lRUCacheMap);
        lRUCacheMap.get(3);    // return 3
        System.out.println(lRUCacheMap);
        lRUCacheMap.get(4);    // return 4
        System.out.println(lRUCacheMap);
    }
}
