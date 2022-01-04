package com.elie;

import com.elie.heapify.Heapify;
import com.elie.strategyPattern.Context;
import com.elie.strategyPattern.OperationAdd;
import com.elie.strategyPattern.OperationMultiply;
import com.elie.strategyPattern.OperationSubstract;
import com.elie.tree.TreeNode;
import com.elie.tree.TreeNodeUtil;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

       Integer[] root = {1,2,3,4,5,6,7,8,9};
       TreeNode rootHead = TreeNodeUtil.createTreeNode(root);
       //TreeNodeUtil.prettyPrintTree(rootHead);
        String a = "http://leetcode.com/problems";

        System.out.println(a.substring(7));
    }


    public String reverseWords(String s) {
        String[] ret = s.split(" ");
        if (ret == null || ret.length == 0) {
            return "";
        }

        StringBuilder retStr = new StringBuilder();
        for (String str : ret) {
            retStr.append(reverseAWords(str));
        }

        return retStr.toString();
    }

    private String reverseAWords(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        int[] ret = new int[str.length()];
        for (int index = 0; index < str.length(); index++) {
            ret[str.length() - index - 1] = str.charAt(index);
        }

        return new String(ret, 0, str.length());
    }


    public static int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }

        int count = 0;
        for(int i = s.length()-1; i >= 0; i--){
            if(s.charAt(i) == ' '){
                if(count == 0) {
                    continue;
                }
                break;
            }
            count++;
        }
        return count;
    }

    public static String compressString(String S) {
        int[] arr = new int[128];

        for (int index = 0; index < S.length(); index++) {
            Character ch = S.charAt(index);
            arr[ch - 'a']++;
        }

        Map<Character, Boolean> map = new HashMap<>();
        StringBuffer ret = new StringBuffer();
        for (int index = 0; index < S.length(); index++) {
            if(map.containsKey(S.charAt(index))) {
                continue;
            } else {
                ret.append(S.charAt(index));
                ret.append(arr[S.charAt(index) - 'a']);
                map.put(S.charAt(index), true);
            }
        }

        return ret.toString();
    }
}
