package com.elie.stringRelated;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        char[] arr = s.toCharArray();
        int head = 0;
        int end = s.length() - 1;

        while (head < end) {
            // find first vowels
            while (!isVowel(arr[head]) && head < s.length()) {
                head++;
            }

            while (!isVowel(arr[end]) && end > 0) {
                end--;
            }

            if (head < end) {
                swap(arr, head, end);
                head++;
                end--;
            }
            // find last vowels

            // change position of first and end

            // search next
        }

        return new String(arr);
    }

    private boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) >= 0 ;
    }

    public void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }



    public String reverseStr(String s, int k) {

        int length = s.length();
        char[] arr = s.toCharArray();

        for (int i = 0; i < length; i += 2 * k) {
            reverseString(arr, i, Math.min(i + k, length) - 1);
        }

        return "";
    }

    private void reverseString(char[] arr, int left, int right) {
        while (left < right) {
            char tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
    }



}
