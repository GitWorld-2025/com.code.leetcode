package com.DataStructures;

import com.DataStructures.Structures.ListNode;

import static com.DataStructures.Structures.ListNode.showList;

public class LinkedListProblems {
    public static void main(String... args) {
        //SwapNodesInPairs();
        //AddTwoNumbers();
        //RemoveNthNodeFromEndofList();
        //FirstCommonOfTwoLinkedLists();
        //IntersectionofTwoLinkedLists();
        //OddEvenLinkedList();
        FindKthLastNode();
    }

    static void SwapNodesInPairs() {
        int[] nums = {1};
        ListNode head = ListNode.createListNodes(nums);

        ListNode first = head;
        ListNode second = head != null ? head.next : null;

        while (first != null && second != null) {
            int val1 = first.val;
            int val2 = second.val;
            first.val = val2;
            second.val = val1;
            first = first.next != null ? first.next.next : null;
            second = second.next != null ? second.next.next : null;
        }
        showList(head);
    }

    static void AddTwoNumbers() {
        ListNode l1 = ListNode.createListNodes(new int[]{9, 9, 9, 9, 9, 9, 9});
        ListNode l2 = ListNode.createListNodes(new int[]{9, 9, 9, 9});
        ListNode head = null;
        ListNode prev = null;
        int carry = 0;
        int h = 0;
        while (l1 != null || l2 != null) {
            int v1 = l1 != null ? l1.val : 0;
            int v2 = l2 != null ? l2.val : 0;
            ListNode node = new ListNode((v1 + v2 + carry) % 10);
            carry = (v1 + v2 + carry) / 10;
            if (h == 0) {
                head = node;
                h++;
            }
            if (prev != null) prev.next = node;
            prev = node;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        if (carry != 0) {
            ListNode node = new ListNode(carry);
            prev.next = node;
        }
        showList(head);
    }

    static void RemoveNthNodeFromEndofList() {
        ListNode head = ListNode.createListNodes(new int[]{1, 2});
        int n = 0;

        //if (head.next == null) return null;
        ListNode fast = head;
        int i = 0;
        while (i <= n) {
            fast = fast.next;
            i++;
        }
        //if (fast == null) return head.next;
        ListNode slow = head;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        if (slow.next != null) slow.next = slow.next.next;
        showList(head);

    }

    public static void FirstCommonOfTwoLinkedLists() {
        ListNode headA = ListNode.createListNodes(new int[]{4, 1, 8, 4, 5});
        ListNode headB = ListNode.createListNodes(new int[]{5, 6, 1, 8, 4, 5});
        ListNode x = headA;
        int x1 = 0;
        ListNode y = headB;
        int y1 = 1;
        while (true) {
            if (x != null && y != null && (x.val == y.val)) {
                break;
            }
            if (x == null && x1 == 0) {
                x = headB;
                x1 = 1;
            } else if (x == null && x1 == 1) {
                x = headA;
                x1 = 0;
            }
            if (y == null && y1 == 1) {
                y = headA;
                y1 = 0;
            } else if (y == null && y1 == 0) {
                y = headB;
                y1 = 1;
            }
            x = x.next;
            y = y.next;
        }

        System.out.println(x.val);
    }

    public static void IntersectionofTwoLinkedLists() {
        ListNode headA = ListNode.createListNodes(new int[]{4, 1});
        ListNode headB = ListNode.createListNodes(new int[]{5, 6, 1});
        ListNode headCommon = ListNode.createListNodes(new int[]{8, 4, 5});
        ListNode hA = headA;
        ListNode hB = headB;
        while (hA.next != null) {
            hA = hA.next;
        }
        while (hB.next != null) {
            hB = hB.next;
        }
        hA.next = headCommon;
        hB.next = headCommon;

        ListNode ptrA = headA;
        ListNode ptrB = headB;

        while (ptrA != ptrB) { // loop until we found the first common node
            ptrA = ptrA == null ? headB : ptrA.next; // once we're done with A, move to B
            ptrB = ptrB == null ? headA : ptrB.next; // once we're done with B, move to A
        }
        System.out.println(ptrA.val);
    }

    public static void OddEvenLinkedList() {
        ListNode head = ListNode.createListNodes(new int[]{2, 1, 3, 5, 6, 4, 7});

        //if(head == null || head.next == null) return head;
        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = even.next.next;
            even = even.next;
        }
        odd.next = evenHead;
    }

    static void FindKthLastNode() {
        ListNode head = ListNode.createListNodes(new int[]{1, 2, 3, 4, 5, 6});
        int k = 3;

        int i = 0;
        ListNode ptr = head;
        while(i < k){
            ptr = ptr.next;
            i++;
        }
        while(ptr != null){
            ptr = ptr.next;
            head = head.next;
        }
        System.out.println(head.val);
    }
}
