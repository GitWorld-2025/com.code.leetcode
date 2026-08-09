package com.TopicSolutions;

import java.util.HashMap;
import java.util.Map;

public class ArraysAndHahing2 {
    public static void main(String... args) {
        //MinimumSumofMountainTripletsI();
        StringCompression();
    }

    static void StringCompression() {
        char[] chars = {'a'};
        Map<Character, Integer> map = new HashMap<>();
        for (char c : chars) map.put(c, map.getOrDefault(c, 0) + 1);
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Character,Integer> e : map.entrySet()){
            sb.append(e.getKey());
            sb.append(e.getValue());
        }
        System.out.println(sb);
    }

    static void MinimumSumofMountainTripletsI() {
        int[] nums = {2, 1, 4, 3};
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = nums[0];
        right[n - 1] = nums[n - 1];
        int total = Integer.MAX_VALUE;

        for (int i = 1; i < n; i++) {
            left[i] = Math.min(left[i - 1], nums[i]);
        }
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.min(right[i + 1], nums[i]);
        }
        for (int i = 1; i < n - 1; i++) {
            if (nums[i] > left[i - 1] && nums[i] > right[i + 1]) {
                total = Math.min(nums[i] + left[i - 1] + right[i + 1], total);
            }
        }
        System.out.println("Minimum Sum of Mountain Triplets I : " + (total == Integer.MAX_VALUE ? -1 : total));
    }
}
