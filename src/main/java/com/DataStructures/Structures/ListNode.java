package com.DataStructures.Structures;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode createListNodes(int... values) {
        ListNode head = null;
        int size = values.length - 1;
        ListNode prev = null;
        while(size >= 0) {
            ListNode node = new ListNode(values[size],prev);
            prev = node;
            head = node;
            size--;
        }
        return head;
    }

    public static void showList(ListNode node){
        while(node!=null){
            System.out.println(node.val);
            node = node.next;
        }
    }
}
