package com.progpractice;

import java.util.Arrays;

public class JVPractice {
    public static void main(String... args) {
        TargetSumCaller();
    }

    static void TargetSumCaller() {
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;
        /// backtracking
        System.out.println("Target Sum BackTracking : " + TargetSumBackTracking(nums, target, 0, 0));
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        int result = TargetSumBackMemoisation(nums, target, 0, 0, dp);
        System.out.println("Target Sum Memoisation : " + result);
    }

    static int TargetSumBackTracking(int[] nums, int target, int total, int index) {
        if (index == nums.length) return total == target ? 1 : 0;
        return TargetSumBackTracking(nums, target, total + nums[index], index + 1)
                + TargetSumBackTracking(nums, target, total - nums[index], index + 1);
    }

    static int TargetSumBackMemoisation(int[] nums, int target, int total, int index, int[] dp) {
        if (index == nums.length) return total == target ? 1 : 0;
        if (dp[index] != -1) return dp[index];
        return dp[index] = TargetSumBackMemoisation(nums, target, total + nums[index], index + 1, dp)
                + TargetSumBackMemoisation(nums, target, total - nums[index], index + 1, dp);
    }

    static void TargetSumTabulation() {
    }
}
