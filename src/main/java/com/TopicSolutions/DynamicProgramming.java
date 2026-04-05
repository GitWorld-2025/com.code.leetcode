package com.TopicSolutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DynamicProgramming {
    public static void main(String... args) {
        //MinimumPathSum();
        //FibonacciCaller();
        //climbStairsCaller();
        //generatePascalsTriangle(5);
        //MinCostClimbingStairsCaller();
        HouseRobberCaller();
    }

    /// Start : House Robber
    static void HouseRobberCaller() {
        int[] nums = {2,7,9,3,1};
        //HouseRobberTabulation(nums);
        int[] memo = new int[nums.length];
        Arrays.fill(memo,-1);
        HoueRobberMemosiation(nums,memo,0);
        int loot = HoueRobberMemosiation(nums,memo,0);
        System.out.println("House Robber : " + loot);

    }
    static int HoueRobberMemosiation(int[] nums, int[] memo,int index){
        if(index >= nums.length) return 0;
        if(memo[index] != -1) return memo[index];
        return memo[index] =  Math.max(HoueRobberMemosiation(nums,memo,index+1),nums[index] + HoueRobberMemosiation(nums,memo,index+2));
    }
    static void HouseRobberTabulation(int[] nums) {
        //int[] loot = new int[nums.length];
        for (int i = nums.length - 3; i >= 0; i--) {
            if(i == nums.length - 3) nums[i] = nums[i] + nums[i+2];
            else nums[i] = nums[i] + Math.max(nums[i+2], nums[i+3]);
        }
        int loot = Math.max(nums[0],nums[1]);
        System.out.println("House Robber : " + loot);
    }
    /// END : House Robber

    /// START : Min Cost Climbing Stairs
    static void MinCostClimbingStairsCaller() {
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        //MinCostClimbingStairsTabulation(cost);
        int[] memo = new int[cost.length];
        Arrays.fill(memo,-1);
        int resultMemosation = Math.min(MinCostClimbingStairs(cost, memo, 0),MinCostClimbingStairs(cost, memo, 1));
        System.out.println("Min Cost Climbing Stairs Tabulation : " + resultMemosation);
    }

    static void MinCostClimbingStairsTabulation(int[] cost) {
        for (int i = cost.length - 2; i >= 0; i--) {
            if (i == cost.length - 2) {
                cost[i] = cost[i] + Math.min(cost[i + 1], 0);
            } else cost[i] = cost[i] + Math.min(cost[i + 1], cost[i + 2]);
        }
        int totalCost = Math.min(cost[0], cost[1]);
        System.out.println(totalCost);
    }

    static int MinCostClimbingStairs(int[] cost, int[] memo, int index) {
        if (index >= cost.length) return 0;
        if(memo[index] != -1) return memo[index];
        return memo[index] = cost[index] + Math.min(MinCostClimbingStairs(cost, memo, index + 1),MinCostClimbingStairs(cost, memo, index + 2));
    }
    /// END : Min Cost Climbing Stairs

    /// START : Fibonacy series
    static void FibonacciCaller() {
        int n = 11;
        System.out.println(fibonacciRec(11));
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(fibonacciMemoisation(dp, n));
        fibonacciTabulation();
    }

    static void fibonacciTabulation() {
        int n = 11;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        System.out.println(dp[n]);
    }

    static int fibonacciRec(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibonacciRec(n - 1) + fibonacciRec(n - 2);
    }

    static int fibonacciMemoisation(int[] dp, int n) {
        if (dp[n] != -1) return dp[n];
        if (n == 0) return dp[n] = 0;
        if (n == 1) return dp[n] = 1;

        return dp[n] = fibonacciMemoisation(dp, n - 1) + fibonacciMemoisation(dp, n - 2);
    }
    /// END : Fibonacy series

    /// START : PASCAL's triangle
    public static List<List<Integer>> generatePascalsTriangle(int numRows) {
        List<List<Integer>> arr = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            System.out.println("--------------------------------------------");
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
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

    /// START : Minimum Path Sum reuired to to reach end of Grid
    static void MinimumPathSumTabulation() {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};

        int[][] cost = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (i == 0 && j == 0) {
                    cost[i][j] = grid[i][j];
                    continue;
                }
                long top = i == 0 ? Integer.MAX_VALUE : cost[i - 1][j] + grid[i][j];
                long left = j == 0 ? Integer.MAX_VALUE : cost[i][j - 1] + grid[i][j];
                cost[i][j] = Math.toIntExact(Math.min(top, left));
            }
        }
        System.out.println(cost[grid.length - 1][grid[0].length - 1]);
    }
    /// END : Minimum Path reuired to to reach end of Grid

}
