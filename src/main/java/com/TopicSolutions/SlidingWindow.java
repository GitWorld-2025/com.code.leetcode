package com.TopicSolutions;

import java.util.*;


public class SlidingWindow {
    public static void main(String... args) {
        //PermutationinString();
        //BestTimetoBuyandSellStock();
        //LongestSubstringWithoutRepeatingCharacters();
        //LongestRepeatingCharacterReplacementHalfApproach();
        //LongestRepeatingCharacterReplacementSWOptimal();
        //MaximumKWindowAverage();
        ThreeSumClosest();
    }

    static void ThreeSumClosest() {
        int[] nums = {-1, 2, 1, -4};//-4,-1,1,2
        int target = 1;
        int n = nums.length;

        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        for(int i=0;i<n-2;i++)
        {
            int left = i+1,right = n-1;
            while(left < right)
            {
                int sum = nums[i]+nums[left]+nums[right];
                if(Math.abs(target-res)>Math.abs(target-sum))
                    res = sum;
                if(sum == target)
                    break;
                if(sum > target)
                    right--;
                else
                    left++;
            }
        }
        System.out.println("Three Sum Closest : "+ res);
    }

    static void MaximumKWindowAverage() {
        /// Maximum Average Subarray I
        int[] nums = {1, 12, -5, -6, 50, 3};
        int k = 4;

        double maxAverage = 0;
        int i = 0, j = 0;
        int sum = 0;

        while (j < nums.length) {
            if (i + j + 1 <= k) {
                sum += nums[j];
                j++;
            } else {
                sum = sum - nums[i] + nums[j];
                maxAverage = Math.max(maxAverage, (double) sum / k);
                i++;
                j++;
            }
        }
        System.out.println(maxAverage);
    }

    static void LongestRepeatingCharacterReplacementSWOptimal() {
        String s = "AABABBA";
        int k = 1;

        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            HashMap<Character, Integer> count = new HashMap<>();
            int maxf = 0;
            for (int j = i; j < s.length(); j++) {
                count.put(s.charAt(j), count.getOrDefault(s.charAt(j), 0) + 1);
                maxf = Math.max(maxf, count.get(s.charAt(j)));
                if ((j - i + 1) - maxf <= k) {
                    res = Math.max(res, j - i + 1);
                }
            }
        }
        System.out.println("Longest Repeating Character Replacement : " + res);
    }

    static void LongestRepeatingCharacterReplacementHalfApproach() {
        String s = "ABAB";
        int k = 2;

        char[] sArray = s.toCharArray();
        int left = 0, right = 1, lastChange = 0, count = 0, maxLength = 0;

        while (right < sArray.length) {
            if (count == k) {
                maxLength = Math.max(maxLength, right - left + 1);
                left = lastChange;
                right = left + 1;
                count = 0;
            } else if (sArray[left] != sArray[right]) {
                count++;
                lastChange = right;
                right++;
            } else if (sArray[left] == sArray[right]) right++;
        }
        System.out.println("Longest Repeating Character Replacement : " + maxLength);
    }

    static void LongestSubstringWithoutRepeatingCharacters() {
        String s = "xxxx";
        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 1;
        map.put(s.charAt(left), 0);
        while (right < s.length()) {
            if (map.containsKey(s.charAt(right))) {
                left = Math.max(map.get(s.charAt(right)) + 1, left);
            }
            map.put(s.charAt(right), right);
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        System.out.println("Longest Substring Without Repeating Characters : " + maxLength);
    }

    static void BestTimetoBuyandSellStock() {
        int[] prices = {10, 1, 5, 6, 7, 1};

        int maxProfit = 0;
        int left = 0, right = 1;

        while (right < prices.length) {
            if (prices[left] < prices[right]) {
                int profit = prices[right] - prices[left];
                maxProfit = Math.max(maxProfit, profit);

            } else left = right;
            right++;
        }
        System.out.println("Best Time to Buy and Sell Stock : " + maxProfit);
    }

    static void PermutationinString() {
        String s1 = "abc", s2 = "lecabee";
        char[] s1Array = s1.toCharArray();
        Arrays.sort(s1Array);
        boolean flag = false;
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            char[] s2Array = s2.substring(i, i + s1.length()).toCharArray();
            Arrays.sort(s2Array);
            if (Arrays.equals(s1Array, s2Array)) flag = true;
        }
        System.out.println("Permutation In String : " + flag);
    }
}
