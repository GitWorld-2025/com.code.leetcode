package com.Blind75.LRUCache;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheMap<K,V> extends LinkedHashMap<K,V> {
    private final int capacity;

    public LRUCacheMap(int capacity){
        super(capacity,1.0f,true);
        this.capacity = capacity;
    }


    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size()>this.capacity;
    }
}
