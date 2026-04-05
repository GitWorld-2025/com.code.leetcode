package com.Blind75;

import java.util.Arrays;
import java.util.Comparator;

public class LeetCode_2P {
    public static void main(String... args) {
        //PartitionArrayInDisjointInterval();
        //RevereseAnArrayWithoutFunction();
        //MinimumMovesForUniqueInArray();
        //MinimumOperationstoMaketheArrayIncreasing();
        //MinimumNumberofOperationstoMakeElementsinArrayDistinct();
        MaxChunksToSort();
    }

    static void MaxChunksToSort() {
        int[] arr = {4, 3, 2, 1, 0};
        int ans = 0;
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(arr[i], max);
            if (max == i) {
                ans++;
            }
        }
        System.out.println("Maximum Chunks Required to Sort :" + ans);
    }

    static void MinimumNumberofOperationstoMakeElementsinArrayDistinct() {
        int[] nums = {5, 7, 11, 12, 12};
        int operations = 0;
        int[] freqNums = new int[Arrays.stream(nums).max().orElse(0) + nums.length];
        for (int num : nums) freqNums[num]++;
        for (int i = 0; i < nums.length; i++) {
            if (freqNums[nums[i]] > 1) {
                i += 3 - i / 3;
                operations++;
            }
        }
        System.out.println("MinimumNumberofOperationstoMakeElementsinArrayDistinct : " + operations);
    }

    static void MinimumOperationstoMaketheArrayIncreasing() {
        int[] nums = {1, 5, 2, 4, 1};
        int operations = 0;

        for (int i = 1; i < nums.length; i++) {
            while (nums[i] <= nums[i - 1]) {
                nums[i]++;
                operations++;
            }
        }
        for (int num : nums) System.out.println(num);
    }

    static void MinimumMovesForUniqueInArray() {
        int nums[] = {1, 2, 2};
        int result = 0;
        int[] freqNum = new int[Arrays.stream(nums).max().getAsInt() + nums.length];

        for (int num : nums) {
            freqNum[num]++;
        }

        for (int i = 0; i < freqNum.length; i++) {
            if (freqNum[i] <= 1) continue;
            int carry = freqNum[i] - 1;
            freqNum[i] = 1;
            freqNum[i + 1] += carry;
            result += carry;
        }
        for (int i = 0; i < freqNum.length; i++) {
            System.out.println(i + " - " + freqNum[i]);
        }
        System.out.println("Result : " + result);
    }

    static void RevereseAnArrayWithoutFunction() {
        int[] nums = {10, 20, 30, 40, 50, 60};
        for (int i = 0; i < nums.length / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[nums.length - i - 1];
            nums[nums.length - i - 1] = temp;
        }
        for (int num : nums) System.out.println(num);
    }

    static void PartitionArrayInDisjointInterval() {
        int[] nums = {5, 0, 3, 8, 6};
        int index = 1;
        int maxLeft = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < maxLeft) {
                index = i + 1;
                maxLeft = max;
            } else max = Math.max(nums[i], max);
        }
        System.out.println("Max Length of Left subArray : " + index);
    }
}
