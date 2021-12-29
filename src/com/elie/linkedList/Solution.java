package com.elie.linkedList;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class Solution {

    public static void main (String[] args) {
        
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        PriorityQueue<ListNode> q = new PriorityQueue<>((a, b)->a.val - b.val);

        for (int i = 0; i < lists.length; i++) {
            ListNode node = lists[i];
            if(lists[i] != null) {
                q.offer(lists[i]);
            }
            /*while(node != null) {
                q.offer(node);
                node = node.next;
            }*/
        }

        ListNode curr = dummy;
        while (!q.isEmpty()) {
            curr.next = q.poll();
            curr = curr.next;
            if (q.isEmpty()) {
                break;
            }

            if (curr.next != null) {
                q.offer(curr.next);
            }
        }
        return dummy.next;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head  != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }



    private ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}


class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
