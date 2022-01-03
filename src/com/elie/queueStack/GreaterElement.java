package com.elie.queueStack;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class GreaterElement {
    public static void main(String[] args) {
        //int[] nums = {2,1,2,4,3};
        //System.out.println(Arrays.toString(nextGreaterElement(nums)));

        String str = "cbacdcbc";
        System.out.println(smallestSubsequence(str));
    }

    public static String smallestSubsequence(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int[] last = new int[26];

        Set<Integer> visited = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i);
            if (!visited.add(c)) {
                continue;
            }
            while (!stack.isEmpty() && c < stack.peek() && i < last[stack.peek() - 'a']) {
                visited.remove(stack.pop());
            }
            stack.push(c);
        }


        StringBuilder sb = new StringBuilder();
        for (int i : stack) {
            sb.append((char)i);
        }

        return sb.toString();
    }

    private static  int[] nextGreaterElement(int[] nums) {
        int[] res = new int[nums.length];

        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            while(!stack.isEmpty() && nums[i] >= stack.peek()) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        return res;
    }

    //752
    //
}
