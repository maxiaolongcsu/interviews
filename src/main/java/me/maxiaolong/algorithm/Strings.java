package me.maxiaolong.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author maxiaolong
 * created at 2020/8/1
 */
public class Strings {

    public static void main(String[] args) {
        // 1. n括号对的组合
        List<List<Character>> result = nBracket(3);
        result.stream().forEach(System.out::println);
        // 2. 最长递增子序列
        int[] nums = new int[]{1, 3, 5, 4, 7};
        System.out.println(longestIncreaseSequence(nums));
        System.out.println(longestIncreaseContinuousSequence(nums));
        // 3. 最长公共子序列
        System.out.println(longestPublicSequence("abcde", "ace"));
    }

    public static int longestPublicSequence(String str1, String str2){
        int[][] dp = new int[str1.length()+1][str2.length()+1];
        for (int i = 0; i < str1.length(); i++) dp[i][0] = 0;
        for (int i = 0; i < str2.length(); i++) dp[0][i] = 0;

        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                if(str1.charAt(i) == str2.charAt(j)){
                    dp[i+1][j+1] = dp[i][j]  + 1;
                }else{
                    dp[i+1][j+1] = Math.max(dp[i][j+1], dp[i+1][j]);
                }
            }
        }

        return dp[str1.length()][str2.length()];
    }

    public static int longestIncreaseContinuousSequence(int[] nums){
        int[] dp = new int[nums.length];
        for (int i = 0; i < dp.length; i++) dp[i] = 1;

        for (int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[i - 1])
                dp[i] = Math.max(dp[i], 1 + dp[i - 1]);
        }
        return Arrays.stream(dp).max().getAsInt();
    }

    public static int longestIncreaseSequence(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 0; i < dp.length; i++) dp[i] = 1;

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
            }
        }

        return Arrays.stream(dp).max().getAsInt();
    }

    /**
     * 1. n括号的组合
     *
     * @param n
     * @return
     */
    public static List<List<Character>> nBracket(int n) {
        List<List<Character>> result = new ArrayList<>();
        List<Character> path = new ArrayList<>();
        nBracketBacktrack(n, result, path);
        return result;
    }

    private static void nBracketBacktrack(int n, List<List<Character>> result, List<Character> path) {
        if (path.size() == 2 * n) {
            result.add(new ArrayList<>(path));
            return;
        }

        // 直接把循环打开 因为待选列表存在循环关系
        int leftBracketNumber = (int) path.stream().filter(x -> x.charValue() == '(').count();
        int rightBracketNumber = path.size() - leftBracketNumber;
        if (leftBracketNumber < n) {
            path.add('(');
            nBracketBacktrack(n, result, path);
            path.remove(path.size() - 1);
        }
        if (rightBracketNumber < leftBracketNumber) {
            path.add(')');
            nBracketBacktrack(n, result, path);
            path.remove(path.size() - 1);
        }
    }


    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(n, n, "", res);
        return res;
    }

    // DFS
    private static void helper(int nL, int nR, String parenthesis, List<String> res) {
        if (nL == 0 && nR == 0) {
            res.add(parenthesis);
            return;
        }
        helper(nL - 1, nR, parenthesis + "(", res);
        if (nL >= nR) {
            return;
        }
        helper(nL, nR - 1, parenthesis + ")", res);
    }
}
