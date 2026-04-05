package com.TopicSolutions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class BackTracking {
    public static void main(String... args) {
        //CombinationSumCaller();
        //WordSearchCaller();
        //LetterCasePermutationCaller();

    }

    static void LetterCasePermutationCaller() {
        String s = "a1b2";
        List<String> result = new ArrayList<>();
        LetterCasePermutation(s, result, 0);
        for (String str : result) System.out.println(str);
    }

    static void LetterCasePermutation(String s, List<String> result, int idx) {
        if (idx == s.length()) {
            if (!result.contains(s)) result.add(s);

            return;
        }
        if (Character.isLetter(s.charAt(idx))) {
            StringBuilder newS = new StringBuilder(s);
            if (Character.isLowerCase(newS.charAt(idx))) {
                newS.setCharAt(idx, Character.toUpperCase(newS.charAt(idx)));
                LetterCasePermutation(newS.toString(), result, idx + 1);
                newS.setCharAt(idx, Character.toLowerCase(newS.charAt(idx)));
            } else {
                newS.setCharAt(idx, Character.toLowerCase(newS.charAt(idx)));
                LetterCasePermutation(newS.toString(), result, idx + 1);
                newS.setCharAt(idx, Character.toUpperCase(newS.charAt(idx)));

            }
        }
        LetterCasePermutation(s, result, idx + 1);
    }

    /// START : Word Search
    static void WordSearchCaller() {
        String[][] board = {{"A", "B", "C", "D"},
                {"S", "A", "A", "T"},
                {"A", "C", "A", "E"}};

        String word = "CAT";
        boolean flag = false;

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col].equals(String.valueOf(word.charAt(0)))
                        && WordSearchBackTrack(board, word, row, col, 0)) {
                    flag = true;
                }
            }
        }
        System.out.println("Word Serch Result : " + flag);
    }

    static boolean WordSearchBackTrack(String[][] board, String word, int row, int col, int index) {
        int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        if (word.length() == index) return true;
        if (row < 0 || col < 0 || row >= board.length || col >= board[row].length || index >= word.length() || board[row][col].equals("$"))
            return false;
        if (!board[row][col].equals(String.valueOf(word.charAt(index)))) return false;
        String temp = board[row][col];
        board[row][col] = "$";

        for (int[] dir : directions) {
            int new_row = row + dir[0];
            int new_col = col + dir[1];
            if (WordSearchBackTrack(board, word, new_row, new_col, index + 1)) return true;
        }
        board[row][col] = temp;
        return false;
    }
    /// END : Word Search

    /// START : Combination Sum
    static void CombinationSumCaller() {
        int[] nums = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> result = new ArrayList<>();
        CombinationSumRecursion1(nums, target, result, new ArrayList<>(), 0, 0);
        //System.out.println(result);

        List<List<Integer>> result1 = new ArrayList<>();
        CombinationSumRecursionOptimal(nums, target, result1, new ArrayList<>(), 0, 0);
        System.out.println(result1);
    }

    static void CombinationSumRecursion1(int[] nums, int target, List<List<Integer>> result, List<Integer> row, int currSum, int index) {
        if (currSum == target) {
            result.add(new ArrayList<>(row));
            return;
        }
        if (currSum > target || index >= nums.length) return;

        row.add(nums[index]);
        CombinationSumRecursion1(nums, target, result, row, currSum + nums[index], index);
        row.remove(row.size() - 1);
        CombinationSumRecursion1(nums, target, result, row, currSum, index + 1);
    }

    static void CombinationSumRecursionOptimal(int[] nums, int target, List<List<Integer>> result, List<Integer> row, int currSum, int index) {
        if (currSum == target) {
            result.add(new ArrayList<>(row));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (currSum + nums[i] > target) return;
            row.add(nums[i]);
            CombinationSumRecursionOptimal(nums, target, result, row, currSum + nums[i], i);
            row.remove(row.size() - 1);
        }
    }
    /// END : Combination Sum
}
