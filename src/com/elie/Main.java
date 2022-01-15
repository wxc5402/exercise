package com.elie;

import com.elie.linkedList.ListNode;

import java.util.Arrays;
import java.util.List;

public class Main {

    static int counts;

    public static void main(String[] args) {

        int[] arr = {3,1,2};

        //quickSort(arr, 0 , arr.length - 1);
        System.out.println(Arrays.toString(mergeSort(arr)));
    }

    public static int[] mergeSort(int[] array) {
        return devide(array, 0, array.length - 1);
    }

    private static int[] devide(int[] array, int left, int right) {
        if(left >= right) {
            return new int[]{array[left]};
        }
        int mid = left + (right - left) / 2;

        int[] leftResult = devide(array, left, mid);
        int[] rightResult = devide(array, mid + 1, right);
        return merge(leftResult, rightResult);
    }

    private static int[] merge(int[] leftResult, int[] rightResult) {
        int[] res = new int[leftResult.length + rightResult.length];
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < leftResult.length && j < rightResult.length) {
            if (leftResult[i] > rightResult[j]) {
                res[k++] = rightResult[j++];
            } else {
                res[k++] = leftResult[i++];
            }
        }

        while( i < leftResult.length) {
            res[k++] = leftResult[i++];
        }

        while( j < rightResult.length) {
            res[k++] = rightResult[j++];
        }
        return res;
    }


    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        ListNode mid = findMid(head);
        ListNode right = sortList(mid);
        mid.next = null;
        ListNode left = sortList(head);

        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        
        ListNode  dummy = new ListNode(0);
        ListNode cur = dummy;
        while (left != null && right != null) {
            if (left.val >= right.val) {
                cur.next = right;
                right = right.next;
            } else {
                cur.next= left;
                left = left.next;
            }
            cur = cur.next;
        }

        if(left != null) {
            cur.next = left;
        } else {
            cur.next = right;
        }

        return dummy.next;
    }

    private ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
