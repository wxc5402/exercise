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

    static int counts;

    public static void main(String[] args) {

        int[][] arr = {{1,2,3},{3,1,2},{2,3,1}};

        System.out.println(checkValid(arr));
    }

    public static boolean checkValid(int[][] matrix) {
        int N = matrix.length;
        int [] t = new int[N + 1];
        Arrays.fill(t,1);
        t[0] = 0;
        int [][] count = new int[2 * N][N + 1];
        for(int i = 0;i < N;i++){
            /**
             * 先计算横的！在计算竖的！
             */
            for(int j = 0;j < N;j++){
                count[i][matrix[i][j]]++;
                count[i + N][matrix[j][i]] ++;
            }
            if(!Arrays.equals(count[i],t) || !Arrays.equals(count[i + N],t)){
                return false;
            }
        }
        return true;
    }

    public static boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        /*
         *  最简单的状态，如果p[j] 字符不是 * ，状态方程
         *  如 s[i] == p[j] 则 f[i][j] = f[i - 1][j - 1]
         *  如果 p[j] 为 .  则认为s[i] 和 p[j] 肯定匹配, f[i][j] = f[i - 1][j - 1];
         *  如果 p[j] 为 * 则有以下情况:
         *          (因为 * 跟前面一个字符走, 只有s[i] 和 p中*号前一个字符匹配后, *才有作用, 否则只能忽略)
         *          1. s[i] == p[j - 1]  此时可以匹配0个或者多个，因此有 f[i][j] = f[i-1][j] or f[i][j] = f[i][j-2];
         *          2. s[i] != p[j - 1]  此时只能匹配0个， 忽略掉*和前面字符:  f[i][j] = f[i][j-2]
         *
         */
        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;

        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    f[i][j] = f[i][j - 2];
                    if (matches(s, p, i , j -1)) {
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                } else {
                    if (matches(s, p, i, j)) {
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }

        return f[m][n];
    }

    private static boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }

        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }

    public static void ParkingSystem(int big, int medium, int small) {
        counts = (small << 20) | (medium << 10) | big;
    }

    public static boolean addCar(int carType) {
        int bit = ((carType-1)*10);
        if (((counts >> bit) & 0b1111111111) <= 0){
            return false;
        } else {
            counts -= 1 << bit;
            return true;
        }
    }

    public static List<String> buildArray(int[] target, int n) {
        List<String> ret = new ArrayList<>();

        for (int index = 0, num = 1; index < target.length; index++, num++) {
            ret.add("Push");
            if(target[index] != num) {
                ret.add("Pop");
                index--;
            }
        }
        return ret;
    }

    public static int trap(int[] height) {
        int i = 1;
        int LMAX = height[0];
        int j = height.length - 2;
        int RMAX = height[height.length - 1];

        int res = 0;

        while (i <= j) {
            if (LMAX < RMAX) {
                res += Math.max(0, LMAX - height[i]);
                LMAX = Math.max(LMAX, height[i]);
                i++;
            } else {
                res += Math.max(0, RMAX - height[j]);
                RMAX = Math.max(RMAX, height[j]);
                j--;
            }
        }
        return res;
    }

    public static int trap1(int[] height) {
        Stack<Integer> stack = new Stack<>();

        int res = 0;
        int N = height.length;

        /*                                           |
        *  如果想要存水，需要有凹槽,     |               |
        *                            ---------------
        *                      leftwall    pre[]    i
        *  高度由高变低得时候我们不考虑（不存水）， 我们只需要关心高度从低变高得时候， 所以高度增加时开始计算。
        */

        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int pre = stack.pop(); // 已经pop 出前一个元素， 左边墙壁为当前栈顶元素。如果为空则不能存水
                if (stack.isEmpty()) {
                    break;  // 没有左墙壁
                }

                int minHeight = Math.min(height[stack.peek()], height[i]);
                int width = i - stack.peek() - 1;
                res += (minHeight - height[pre]) * width;
            }
            stack.push(i);
        }

        return res;
    }

    public static String removeKdigits(String num, int k) {
        if (k == num.length()) {
            return "0";
        }

        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < num.length(); i++) {
            while (k > 0 && !stack.isEmpty() && num.charAt(i) < stack.peek()) {
                stack.pop();
                k--;
            }

            if (!(num.charAt(i) == '0' && stack.isEmpty())) {
                stack.push(num.charAt(i));
            }
        }

        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }
        return stack.size() == 0 ? "0" : stack2String(stack);
    }

    private static String stack2String(Stack<Character> stack) {
        StringBuffer result = new StringBuffer();
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }
        return result.toString();
    }

    public static String removeDuplicateLetters(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int[] last = new int[128];

        Set<Integer> visited = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i)] = i;
        }

        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i);
            if (!visited.add(c)) {
                continue;
            }
            while (!stack.isEmpty() && c < stack.peek() && i < last[stack.peek()]) {
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

    public static String rankTeams(String[] votes) {
        if (votes.length == 1) {
            return votes[0];
        }
        // key = team;   value = each rank votes 每个排位获得的票数
        HashMap<Character, int[]> map = new HashMap<>();

        for (String str : votes) {
            for (int index = 0; index < str.length(); index++) {
                Character ch = str.charAt(index);
                int[] rankArr = map.getOrDefault(ch, new int[26]);
                rankArr[index]++;
                map.put(ch, map.getOrDefault(ch, rankArr));
            }
        }

        List<Map.Entry<Character, int[]>> teamRankList = new ArrayList<>(map.entrySet());
        Collections.sort(teamRankList, (a, b) ->{
            int[] ranks1 = a.getValue();
            int[] ranks2 = b.getValue();
            for (int i = 0; i < 26; i++) {
                if (ranks1[i] != ranks2[i]) {
                    return ranks2[i] - ranks1[i];
                }
            }

            return a.getKey() - b.getKey();
        });

        return teamRankList.stream().map(entry -> String.valueOf(entry.getKey())).collect(Collectors.joining());
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

    private String getHostName(String url) {
        url = url.substring(7);
        if (url.contains("/")) {
            int end = url.indexOf('/'); // 第一次出现斜杠的索引位置
            return url.substring(0, end);
        } else {
            return url;
        }
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
