package com.TopicSolutions;

import java.util.Arrays;

public class TwoDDynamicProgramming {
    public static void main(String... args) {
        UniquePathsCaller();
        LongestCommonSubsequenceCaller();
    }
    /// START : Longest Common Subsequence
    static void LongestCommonSubsequenceCaller() {
        String text1 = "cat", text2 = "crabt";
        int[][] dp = new int[text1.length()][text2.length()];

        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                dp[i][j] = -1;
            }
        }

        int result = LongestCommonSubsequenceMemoisation(text1, text2, dp, 0, 0);
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(" | " + dp[i][j]);
            }
            System.out.print(" | ");
            System.out.println();
        }
        System.out.println("Longest Common Subsequence Memoisation : " + result);
        LongestCommonSubsequenceTabulation(text1, text2);
    }

    static void LongestCommonSubsequenceTabulation(String text1, String text2) {
        //        String text1 = "cat", text2 = "crabt";
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = text1.length() - 1; i >= 0; i--) {
            for (int j = text2.length() - 1; j >= 0; j--) {
                if (text1.charAt(i) == text2.charAt(j)) dp[i][j] = 1 + dp[i + 1][j + 1];
                else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        System.out.println("Longest Common Subsequence Tabulation : " + dp[0][0]);
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print("|" + dp[i][j]);
            }
            System.out.print("|");
            System.out.println();
        }
    }

    static int LongestCommonSubsequenceMemoisation(String text1, String text2, int[][] dp, int i, int j) {
        //        String text1 = "cat", text2 = "crabt";
        if (i == text1.length() || j == text2.length()) return 0;
        if (dp[i][j] != -1) return dp[i][j];

        if (text1.charAt(i) == text2.charAt(j))
            return dp[i][j] = 1 + LongestCommonSubsequenceMemoisation(text1, text2, dp, i + 1, j + 1);

        return dp[i][j] = Math.max(LongestCommonSubsequenceMemoisation(text1, text2, dp, i + 1, j),
                LongestCommonSubsequenceMemoisation(text1, text2, dp, i, j + 1));
    }
    /// END : Longest Common Subsequence

    /// START : Unique Path
    static void UniquePathsCaller() {
        int m = 3, n = 7;
        int[][] cache = new int[m][n];
        for(int[] row : cache) Arrays.fill(row,-1);
        UniquePathsMemoisation(m,n,cache,0,0);
        System.out.println(cache[0][0]);
        //UniquePathsTabulation(m, n);
    }

    static int UniquePathsMemoisation(int m, int n, int[][] cache, int i, int j) {
        if (i == m-1 && j == n-1) return 1;
        if (i >= m || j >= n) return  0;
        if(cache[i][j] != -1) return cache[i][j];
        return cache[i][j] = UniquePathsMemoisation(m, n, cache, i + 1, j) + UniquePathsMemoisation(m, n, cache, i, j + 1);
    }

    static void UniquePathsTabulation(int m, int n) {
        int[][] cache = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                if (i == 0) cache[i][j]++;
                else if (j == 0) cache[i][j]++;
                else cache[i][j] = cache[i - 1][j] + cache[i][j - 1];
            }
        }
        System.out.println(cache[m - 1][n - 1]);
    }
    /// END : Unique Path
}
