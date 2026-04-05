package com.TopicSolutions;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GreedyAlgo {
    public static void main(String... args) {
        //findtheminimumnumberofcoins();
        //PartitionLableAndSpliceGame();
        //MaximumSubArray();
        //JumpGame();
        //BestTimetoBuyandSellStockUsingTwoPointersArray();
        //BestTimetoBuyandSellStockWithTransactionFee();
        //minimumSize(null,4);//Minimum Limit of Balls in Bag
        //IncreasingTripletSubsequence();
        //canPlaceFlowers(int[] flowerbed, int n)
        //AssignCookies();
        //longestPalindrome();
        //GasStation();
        //ValidateStackSequences();
        MinimumAddtoMakeParenthesesValid();
    }

    static void MinimumAddtoMakeParenthesesValid() {
        String s = "(((";
        int open = 0, close = 0;
        for (char ch : s.toCharArray()) {
            if(ch == ')') {
                if(open > 0) open --;
                else close++;
            }else open ++;
        }

        System.out.println(Math.abs(open + close));
    }

    static void ValidateStackSequences() {
        ///  Greedy and Stack problem
        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {4, 3, 5, 1, 2};
        boolean flag = false;

        Stack<Integer> st = new Stack<>();
        int push = 0, pop = 0;

        while (push < pushed.length || !st.isEmpty()) {
            if (pop == popped.length - 1) {
                flag = true;
                break;
            } else if (!st.isEmpty() && popped[pop] == st.peek()) {
                pop++;
                st.pop();
            } else {
                if (push < pushed.length) {
                    st.push(pushed[push]);
                    push++;
                } else break;
            }
        }
        System.out.println("Validate Stack Sequences : " + flag);
    }

    public static void GasStation() {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        if (Arrays.stream(gas).sum() > Arrays.stream(cost).sum()) System.out.println("Valid Gas Station Problem");

        int totalCost = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            totalCost += gas[i] - cost[i];
            if (totalCost < 0) {
                totalCost = 0;
                start = i + 1;
            }
        }
        System.out.println("Gas Station Start position : " + start);
    }

    public static void minimumCost() {
        int[] nums = {1, 2, 3, 12};
        Arrays.sort(nums, 1, nums.length);
        System.out.println("divide-an-array-into-subarrays-with-minimum-cost-i/ " + (nums[0] + nums[1] + nums[2]));
    }

    static public void longestPalindrome() {
        String s = "abccccdd";
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        int maxLength = 0;
        boolean hasOddfreq = false;

        for (Map.Entry entry : frequencyMap.entrySet()) {
            if ((int) entry.getValue() % 2 == 0) {
                maxLength += (int) entry.getValue();
            } else {
                maxLength = maxLength + (int) entry.getValue() - 1;
                hasOddfreq = true;
            }
        }
        if (hasOddfreq) {
            System.out.println("Maximum Length : " + (maxLength + 1));
        } else System.out.println("Maximum Length : " + maxLength);
        ;
    }

    static void AssignCookies() {
        int[] g = {1, 2, 3}, s = {3};
        Arrays.sort(g);
        Arrays.sort(s);
        int contentSon = 0;
        int cookieIndex = 0;

        while (cookieIndex < s.length && contentSon < g.length) {
            if (s[cookieIndex] >= g[contentSon]) {
                contentSon++;
            }
            cookieIndex++;
        }
        System.out.println("No of Children satisfied : " + contentSon);
    }


    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            // Check if the current plot is empty.
            if (flowerbed[i] == 0) {
                // Check if the left and right plots are empty.
                boolean emptyLeftPlot = (i == 0) || (flowerbed[i - 1] == 0);
                boolean emptyRightPlot = (i == flowerbed.length - 1) || (flowerbed[i + 1] == 0);

                // If both plots are empty, we can plant a flower here.
                if (emptyLeftPlot && emptyRightPlot) {
                    flowerbed[i] = 1;
                    count++;
                    if (count >= n) {
                        return true;
                    }
                }
            }
        }
        return count >= n;
    }

    public static int minimumSize(int[] nums, int maxOperations) {
        nums = new int[]{2, 4, 8, 2};
        maxOperations = 4;
        // Binary search bounds
        int left = 1;
        int right = 0;

        for (int num : nums) {
            right = Math.max(right, num);
        }

        // Perform binary search to find the optimal maxBallsInBag
        while (left < right) {
            int middle = (left + right) / 2;

            // Check if a valid distribution is possible with the current middle value
            if (isPossible(middle, nums, maxOperations)) {
                right = middle; // If possible, try a smaller value (shift right to middle)
            } else {
                left = middle + 1; // If not possible, try a larger value (shift left to middle + 1)
            }
        }

        // Return the smallest possible value for maxBallsInBag
        return left;
    }

    // Helper function to check if a distribution is possible for a given maxBallsInBag
    static boolean isPossible(int maxBallsInBag, int[] nums, int maxOperations) {
        int totalOperations = 0;

        // Iterate through each bag in the array
        for (int num : nums) {
            // Calculate the number of operations needed to split this bag
            int operations = (int) Math.ceil(num / (double) maxBallsInBag) - 1;
            totalOperations += operations;

            // If total operations exceed maxOperations, return false
            if (totalOperations > maxOperations) {
                return false;
            }
        }

        // We can split the balls within the allowed operations, return true
        return true;
    }

    static void IncreasingTripletSubsequence() {
        int[] nums = {2, 1, 5, 0, 4, 6};
        int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE;
        boolean flag = false;
        for (int num : nums) {
            if (num <= a) {
                a = num;
            } else if (num <= b) {
                b = num;
            } else {
                flag = true;
            }
        }

        System.out.println("IncreasingTripletSubsequence Present : " + flag);
    }

    static void BestTimetoBuyandSellStockWithTransactionFee() {
        int[] prices = {1, 3, 2, 8, 4, 9};
        int fee = 2;
        int buy = Integer.MIN_VALUE;
        int sell = 0;

        for (int price : prices) {
            buy = Math.max(buy, sell - price);
            sell = Math.max(sell, buy + price - fee);
        }
        System.out.println("Final Sell : " + sell);
    }

    static void BestTimetoBuyandSellStockUsingTwoPointersArray() {
        int[] prices = {7, 1, 5, 3, 6, 4};

        int pDay = 0;
        int sDay = 1;
        int profit = 0;
        while (sDay < prices.length) {
            if (prices[sDay] > prices[pDay]) {
                profit = Math.max(profit, prices[sDay] - prices[pDay]);
            } else {
                pDay = sDay;
            }
            sDay++;
        }
        System.out.println(profit);
    }

    static void JumpGame() {
        int[] nums = {2, 3, 1, 1, 4};
        int goal = nums.length - 1;
        boolean flag = false;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= goal) {
                goal = i;
            }
        }
        flag = goal == 0;
    }

    static void MaximumSubArray() {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int maxSumHere = nums[0];
        int maxSumSoFar = nums[0];
        if (nums.length == 1) ;//return nums[0];
        for (int i = 0; i < nums.length; i++) {
            maxSumHere = Math.max(nums[i], maxSumHere + nums[i]);
            maxSumSoFar = Math.max(maxSumSoFar, maxSumHere);
        }
        System.out.println(maxSumSoFar);
    }

    static void PartitionLableAndSpliceGame() {
        String s = "ababcbacadefegdehijhklij";

        Map<Character, Integer> lastOccurance = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            lastOccurance.put(s.charAt(i), i);
        }
        int start = 0, end = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, lastOccurance.get(s.charAt(i)));
            if (i == end) {
                res.add(end - start + 1);
                start = end + 1;
            }
        }
        /// Partition Lables
        System.out.println(res);
        /// Splice Game
        Integer score = res.stream().map(i -> i * i).reduce(0, (a, b) -> a + b);
        System.out.println(score);
    }


    static void findtheminimumnumberofcoins() {
        int[] coins = {1, 5, 2, 10};
        int amount = 39;
        Arrays.sort(coins);
        int noOfCoins = 0;
        for (int i = coins.length - 1; i >= 0; i--) {
            int coinCount = 0;
            if (amount >= coins[i]) {
                coinCount = amount / coins[i];
                noOfCoins += coinCount;
                amount = amount - (coinCount * coins[i]);
            }
        }
        System.out.println(noOfCoins);
    }
}
