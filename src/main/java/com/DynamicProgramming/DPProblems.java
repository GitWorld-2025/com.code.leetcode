package com.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DPProblems {
    public static void main(String... args) {
        //fibonacciCaller();
        //climbStairsCaller();
        generatePascalsTriangle(5);
    }

    /// START : PASCAL's triangle
    public static List<List<Integer>> generatePascalsTriangle(int numRows) {
        List<List<Integer>> arr = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            System.out.println("--------------------------------------------");
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i){
                    row.add(1);
                }
                else{
                    row.add(arr.get(i - 1).get(j) + arr.get(i - 1).get(j - 1));
                }
            }
            arr.add(row);
        }
        return arr;
    }


    /// END : PASCAL's triangle

    ///  START : Climb Stairs - climb 1 or 2 steps for int n - return no. of ways
    static void climbStairsCaller() {
        int stairs = 3;
        //System.out.println(findClimbStairsRecursion(stairs));
        int[] memo = new int[stairs + 1];
        Arrays.fill(memo, -1);
        System.out.println(findClimbStairsMemoisation(memo, stairs));

        System.out.println(findClimbStairsTabulation(stairs));
    }

    static int findClimbStairsRecursion(int remStairs) {
        if (remStairs == 0 || remStairs == 1) {
            return 1;
        }
        return findClimbStairsRecursion(remStairs - 1) + findClimbStairsRecursion(remStairs - 2);
    }

    static int findClimbStairsMemoisation(int[] memo, int remStairs) {
        if (remStairs == 0 || remStairs == 1) return 1;
        if (memo[remStairs] != -1) return memo[remStairs];
        return memo[remStairs] = findClimbStairsMemoisation(memo, remStairs - 1) + findClimbStairsMemoisation(memo, remStairs - 2);
    }

    static int findClimbStairsTabulation(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
    ///  END : Climb Stairs - climb 1 or 2 steps for int n

    /// Fibonacy series  Start
    static void fibonacciCaller() {
        //0,1,1,2,3,5,8,13,21,34
        int num = 10;
        int[] dp = new int[11];
        Arrays.fill(dp, -1);
        System.out.println("Result + " + fibRec(num, dp));
        Arrays.stream(dp).boxed().forEach(System.out::println);
    }

    static int fibRec(int num, int[] dp) {
        if (dp[num] != -1) return dp[num];
        if (num == 0 || num == 1) return dp[num] = num;
        else {
            return dp[num] = fibRec(num - 1, dp) + fibRec(num - 2, dp);
        }
    }

    /// Fibonacy series  end
    /// Longest Common Subsequence DP Start
    static void longestCommonSubsequence() {
        String text1 = "zbd";
        String text2 = "abcdef";
        //LCSRecursionBottomUpTabulation(text1, text2);
        //LCSRecursionBottomUpMemoisation(text1, text2);
    }

    static void LCSRecursionBottomUpTabulation(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m + 1][n + 1];
        printDP(dp);
        System.out.println("----------------------------------------------");
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j],
                            dp[i][j - 1]);
                }
            }
            System.out.println("----------------------------------------------");
            printDP(dp);
            System.out.println("----------------------------------------------");

        }

        System.out.println(dp[m][n]);
    }

    static void printDP(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(" | " + dp[i][j]);
            }
            System.out.println();
        }
    }

    static void LCSRecursionBottomUpMemoisation(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] memo = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            Arrays.fill(memo[i], -1);
        }
        int lcs = lcsRec(text1, text2, m, n, memo);
    }

    static int lcsRec(String s1, String s2, int m, int n,
                      int[][] memo) {
        System.out.println("----------------------------------------------");
        printDP(memo);
        System.out.println("----------------------------------------------");
        // Base Case
        if (m == 0 || n == 0)
            return 0;

        // Already exists in the memo table
        if (memo[m][n] != -1)
            return memo[m][n];

        // Match
        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            return memo[m][n]
                    = 1 + lcsRec(s1, s2, m - 1, n - 1, memo);
        }

        // Do not match
        return memo[m][n]
                = Math.max(lcsRec(s1, s2, m, n - 1, memo),
                lcsRec(s1, s2, m - 1, n, memo));
    }
    /// Longest Common Subsequence Ends


}
