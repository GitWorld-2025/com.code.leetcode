package com.CompanyQuestions.MyHashMap;

import java.util.Arrays;
import java.util.List;

class MyHashMap {
    ListNode[] map;
    public MyHashMap() {
        this.map = new ListNode[1000];
        for(int i = 0; i< map.length;i++) map[i] = new ListNode();
    }

    public int hashCode(int key){
        return key%map.length;
    }
    public void put(int key, int value) {
        int hashCode = this.hashCode(key);
        ListNode head = map[hashCode];
        while(head.next!=null){
            if(head.next.key == key) {
                head.next.value = value;
                return;
            }
            head = head.next;
        }
        ListNode newNode = new ListNode(key,value);
        head.next = newNode;
        System.out.println("PUT : key - "+head.key+" || value : "+head.value);
    }

    public int get(int key) {
        int hashCode = this.hashCode(key);
        ListNode head = map[hashCode];
        while(head.next != null){
            if(head.next.key == key){
                return head.next.value;
            }
            head = head.next;
        }
        return -1;
    }

    public void remove(int key) {
        int hashCode = this.hashCode(key);
        ListNode head = map[hashCode];
        while(head.next != null){
            if(head.next.key == key){
                head.next = head.next.next;
                return;
            }
            head = head.next;
        }
    }
}
