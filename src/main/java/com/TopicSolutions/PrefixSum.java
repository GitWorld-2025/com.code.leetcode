package com.TopicSolutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrefixSum {
    public static void main(String... args) {
        //RangeSumQueryImmutable();
        //LongestSubArrayWithSumK();
        //SubarraySumEqualsK();
        //circularMaxSumSubarray();
        //SubarraySumsDivisiblebyK();
        IndexedOfSubArraySum();
    }

    static void SubarraySumsDivisiblebyK() {
        int[] nums = {4, 5, 0, -2, -3, 1};
        int k = 5;

        /// Optimal solution : HashMap
        Map<Integer, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0, 1);
        int prefixSum = 0, result = 0;

        for (int num : nums) {
            prefixSum += num;
            int remainder = prefixSum % k;
            if (remainder < 0) remainder += k;

            result += prefixMap.getOrDefault(remainder, 0);
            prefixMap.put(remainder, prefixMap.getOrDefault(remainder, 0) + 1);
        }
        System.out.println("SubarraySumsDivisiblebyK OptimalHashMap : " + result);

        /// Brute Force
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum % k == 0) count++;
            }
        }
        System.out.println("SubarraySumsDivisiblebyK BruteForce : " + count);
    }

    static void circularMaxSumSubarray() {
        int[] nums = {1, 5, -3, 2, -1, -5, 6, 4};
        int curMax = 0;
        int curMin = 0;
        int minSum = nums[0];
        int maxSum = nums[0];
        int totalSum = 0;
        for (int num : nums) {
            curMax = Math.max(curMax, 0) + num;
            maxSum = Math.max(maxSum, curMax);

            curMin = Math.min(curMin, 0) + num;
            minSum = Math.min(minSum, curMin);

            totalSum += num;
        }
        if (totalSum == minSum) totalSum = minSum;
        else totalSum = Math.max(maxSum, totalSum - minSum);

        System.out.println("circularMaxSumSubarray : " + totalSum);
    }

    static void SubarraySumEqualsK() {
        int[] nums = {1, 2, 3, -3, 1, 1, 1, 4, 2, -3};
        int k = 3;

        int count = 0, currSum = 0;
        Map<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0, 1);

        for (int num : nums) {
            currSum += num;
            int diff = currSum - k;
            count += prefixSum.getOrDefault(diff, 0);
            prefixSum.put(currSum, prefixSum.getOrDefault(currSum, 0) + 1);
        }
        System.out.println("No of SubArray with sum k : " + count);
    }

    static void IndexedOfSubArraySum() {
        int[] nums = {1, 2, 3, 7, 5};
        int target = 12;

        List<List<Integer>> result = new ArrayList<>();
        int sum = 0, i = 0, j = 0;
        while (j < nums.length) {
            if(sum == target) {
                List<Integer> list = new ArrayList<>();
                list.add(i+1);
                list.add(j);
                result.add(list);
                break;
            }
            else if(sum > target){
                sum -= nums[i];
                i++;
            }else {
                sum += nums[j];
                j++;
            }
        }
        System.out.println(result);
    }

    static void LongestSubArrayWithSumK() {
        int[] nums = {10, 5, 2, 7, 1, 9};
        int k = 15;

        /// Initialize
        int maxLength = 0;
        int left = 0, right = 0;
        int sum = nums[0];

        while (right < nums.length) {
            /// Shrink Array from left if sum > k
            while (left <= right && sum > k) {
                sum -= nums[left];
                left++;
            }
            /// If sum == k , subarray found, calculate length and compare/store in maxLength
            if (sum == k) {
                maxLength = Math.max(maxLength, right - left + 1);
            }
            /// if sum < k, increase size of sub array right++, add num in sum
            right++;
            if (right < nums.length) {
                sum += nums[right];
            }
        }
        System.out.println("Longest SubArray with Sum : " + maxLength);
    }

    static void RangeSumQueryImmutable() {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        for (int num : prefixSum) System.out.println(num);
        /// Find Range Sum between 0 & 5 (If left == 0 || return right)
        System.out.println(prefixSum[2]);
        /// Find Range Sum between 2 & 5 (If left == 0 || return right - (left -1))
        System.out.println(prefixSum[5] - prefixSum[2 - 1]);

        /// Find Range Sum between 0 & 5 (If left == 0 || return right)
        System.out.println(prefixSum[5]);

    }

}
