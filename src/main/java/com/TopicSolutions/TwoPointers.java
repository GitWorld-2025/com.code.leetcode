package com.TopicSolutions;

import java.util.*;

public class TwoPointers {
    public static void main(String... args) {
        //ValidPalindrom();
        //ThreeSum();
        //ContainerWithMostWater();
        //BestTimetoBuyandSellStock();
        //LongestSubstringWithoutRepeatingCharacters();
        //BoatstoSavePeople();
        //MaximumWidthRamp();
        RearrangeArrayElementsbySign();
    }

    static void RearrangeArrayElementsbySign() {
        int[] nums = {19, -26, -37, -10, -9, 15, 14, 31};
        int[] newNums = new int[nums.length];
        int positive = 0, negative = 1;
        for (int num : nums) {
            if (num > 0) {
                newNums[positive] = num;
                positive += 2;
            } else {
                newNums[negative] = num;
                negative += 2;
            }
        }
        for (int num : newNums) System.out.println(num);
    }


    /// Maximum Width Ramp
    static void MaximumWidthRamp() {
        int[] nums = {9, 8, 1, 0, 1, 9, 4, 0, 4, 1};
        int[] maxArr = new int[nums.length];
        int max = 0;
        for (int i = maxArr.length - 1; i >= 0; i--) {
            maxArr[i] = max = Math.max(max, nums[i]);
        }
        int maxLength = 0;

        for (int i = 0; i < nums.length; i++) {
            int left = nums[i];
            int j = i + 1;
            while (j < nums.length && left <= maxArr[j]) {
                maxLength = Math.max(maxLength, j - i);
                j++;
            }
        }
        System.out.println("Maximum Width Ramp : " + maxLength);
    }

    static void BoatstoSavePeople() {
        //int[] people = {1, 3, 2, 2, 1, 2};
        int[] people = {3, 2, 2, 1};
        int limit = 3;

        Arrays.sort(people);
        int boats = 0;
        int left = 0, right = people.length - 1;
        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
                right--;
                boats++;
            } else if (people[right] > limit - people[left]) {
                right--;
                boats++;
            } else {
                left++;
                boats++;
            }
        }
        System.out.println("Boats to Save People : " + boats);
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

    static void ContainerWithMostWater() {
        int[] height = {1, 7, 2, 5, 4, 7, 3, 6};
        int mostWater = 0;
        int left = 0, right = height.length - 1;

        while (left < right) {
            int sum = Math.min(height[left], height[right]) * (right - left);
            mostWater = Math.max(sum, mostWater);
            if (height[left] <= height[right]) left++;
            else right--;
        }
        System.out.println("Container With Most Water : " + mostWater);
    }

    static void ThreeSum() {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left <= right) {
                if (nums[i] + nums[left] + nums[right] == 0) {
                    List<Integer> row = new ArrayList<>();
                    row.add(nums[i]);
                    row.add(nums[left]);
                    row.add(nums[right]);
                    result.add(row);
                    break;
                } else if (nums[left] + nums[right] > nums[i]) right--;
                else {
                    left++;
                }
            }

        }
        System.out.println(result);
    }

    static void ValidPalindrom() {
        String str = "1Was it a car or a cat I saw9";
        String str2 = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        System.out.println(str2);
        boolean flag = true;
        for (int i = 0; i < str2.length() / 2; i++) {
            if (str2.charAt(i) != str2.charAt(str2.length() - i - 1)) flag = false;
        }

        System.out.println("Valid Palindrome : " + flag);
    }
}
