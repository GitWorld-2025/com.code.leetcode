package com.TopicSolutions;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearch {
    public static void main(String... args) {
        //ArrayNesting();
        ScoreofParentheses();
    }

    static void ScoreofParentheses() {
        String s = "()(())";
        int depth = 0;
        int score = 0;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(') depth++;
            else {
                depth--;
                if(s.charAt(i-1) == '(')
                    score += 1 << depth;
            }
        }

        System.out.println("Score of Parentheses : " + score);
    }

    static void ArrayNesting() {
        int[] nums = {5, 4, 0, 3, 1, 6, 2};

        /// Optimal approach
        int maxSize = 0;
        for (int num : nums) {
            if (num == -1) continue;
            int index = num;
            int count = 0;
            while (nums[index] != -1) {
                int cache = index;
                index = nums[cache];
                nums[cache] = -1;
                ++count;
            }
            maxSize = Math.max(maxSize, count);
        }
        /// Brute Force;
        int numbers = nums.length - 1;
        int size = 0;
        for (int i = 0; i <= numbers; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(nums[i]);
            while (true) {
                int temp = nums[list.get(list.size() - 1)];
                if (list.contains(temp)) break;
                else list.add(temp);
            }
            size = Math.max(size, list.size());
        }
        System.out.println("Array Nesting : " + maxSize);
    }
}
