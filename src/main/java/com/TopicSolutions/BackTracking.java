package com.TopicSolutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class BackTracking {
    public static void main(String... args) {
        //CombinationSumCaller();
        //WordSearchCaller();
        //LetterCasePermutationCaller();
        //generatePermutations();
        //wordSearchCaller();
        //combinationSumCaller();
        //permutationsCaller();
        //findSubset();
        //generateParanthesis();
        findCombinationOfSigns();
    }
    /// START : Find String of combination of signs where all digits give zero
    static void findCombinationOfSigns(){
        int num = 198;
        String numStr = String.valueOf(num);
        int[] digits = new int[numStr.length()];
        List<String> result = new ArrayList<>();
        for(int i = 0; i < numStr.length(); i++){
            digits[i] = Character.getNumericValue(numStr.charAt(i));
        }
        findCombinations(digits, 1, digits[0], "", result);

        result.stream().forEach(System.out::println);
    }

    static void findCombinations(int[] digits, int index, int curSum, String str,
                                 List<String> result){
        if(index == digits.length) {
            if(curSum == 0) result.add(str);
            return;
        }

        findCombinations(digits, index + 1, curSum - digits[index], str+"-", result);
        findCombinations(digits, index + 1, curSum + digits[index], str+"+", result);
    }
    /// END : Find String of combination of signs where all digits give zero

    /// Generate Permutations where given combination of words not present
    public static void generatePermutations() {
        String input = "ABC";
        List<String> result = new ArrayList<>();
        backtrack("", input, result);
        System.out.println("Permutations of \"" + input + "\" without \"EF\":");
        for (String perm : result) {
            System.out.println(perm);
        }
    }

    private static void backtrack(String currentPermutation, String remainingChars, List<String> result) {
        // Base case: If no characters are remaining, a full permutation is formed
        if (remainingChars.isEmpty()) {
            // Check the constraint before adding to the result
            if (!currentPermutation.contains("EF")) {
                result.add(currentPermutation);
            }
            return;
        }

        // Recursive step: Iterate through remaining characters
        for (int i = 0; i < remainingChars.length(); i++) {
            char charToAppend = remainingChars.charAt(i);
            String nextPermutation = currentPermutation + charToAppend;
            String nextRemaining = remainingChars.substring(0, i) + remainingChars.substring(i + 1);

            // Pruning: If the current partial permutation already contains "AB", stop this branch
            if (nextPermutation.contains("BC")) {
                continue;
            }

            // Recurse with the new partial permutation and remaining characters
            backtrack(nextPermutation, nextRemaining, result);
        }
    }

    /// End
    /// Word Search problem
    static void wordSearchCaller() {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        char[] word = {'S', 'E', 'G'};
        boolean flag = false;

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == word[0] && wordFind(board, row, col, 0, word)) {
                    flag = true;
                }
            }
        }
        System.out.println("Word SEE found / Not found : " + flag);
    }

    static boolean wordFind(char[][] board, int i, int j, int idx, char[] word) {
        int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

        if (idx == word.length) return true;
        if (i < 0 || j < 0 || i >= board.length || j >= board[i].length || board[i][j] == '$') {
            return false;
        }
        if (board[i][j] != word[idx]) return false;

        char temp = board[i][j];
        board[i][j] = '$';

        for (int[] dir : directions) {
            int new_i = i + dir[0];
            int new_j = j + dir[1];
            if (wordFind(board, new_i, new_j, idx + 1, word)) {
                return true;
            }
        }
        board[i][j] = temp;
        return false;
    }

    /// End ///////

    /// Find combination of sum which matches Target
    static void combinationSumCaller() {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> result = findCombinationSumList(candidates, target);
        result.forEach(System.out::println);
    }

    static List<List<Integer>> findCombinationSumList(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        makeCombination(candidates, target, list, result, 0);
        return result;
    }

    static void makeCombination(int[] candidates, int remSum, List<Integer> list, List<List<Integer>> result, int index) {
        if (remSum == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        if (remSum < 0 || index >= candidates.length) return;

        list.add(candidates[index]);

        makeCombination(candidates, remSum - candidates[index], list, result, index);
        list.remove(list.size() - 1);
        makeCombination(candidates, remSum, list, result, index + 1);
    }
    /// End ///////

    /// Find Permutations ///////

    static void permutationsCaller() {
        int[] nums = {1, 2, 3};

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        /// Using boolean flag
        backtrackPermutationsUsingBoolean(nums, list, result, used);
        System.out.println(result);
    }

    static void backtrackPermutationsUsingBoolean(int[] nums, List<Integer> list, List<List<Integer>> result, boolean[] used) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            list.add(nums[i]);
            used[i] = true;
            backtrackPermutationsUsingBoolean(nums, list, result, used);
            list.remove(list.size() - 1);
            used[i] = false;
        }
    }

    /// End ///////

    /// Find Subset - (The power set)
    static void findSubset() {
        int[] nums = {1, 2, 3};

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        List<Integer> numList = Arrays.stream(nums).boxed().toList();
        backTrackingSubSet(numList, list, result, 0);
        result.forEach(System.out::println);
    }

    static void backTrackingSubSet(List<Integer> numList, List<Integer> list, List<List<Integer>> result, int index) {
        if (index == numList.size()) {
            result.add(new ArrayList<>(list));
            return;
        }
        list.add(numList.get(index));
        backTrackingSubSet(numList, list, result, index + 1);
        list.remove(list.size() - 1);
        backTrackingSubSet(numList, list, result, index + 1);
    }

    /// End
    /// Generate Paranthesis

    static void generateParanthesis() {
        int n = 3;
        int open = 0;
        int close = 0;
        List<String> result = new ArrayList<>();
        generaterPara(n, open, close, "", result);
        result.forEach(System.out::println);
    }

    static void generaterPara(int n, int open, int close, String current, List<String> result) {
        if (open == close && open + close == 2 * n) {
            result.add(current);
            return;
        }
        if (open < n) {
            generaterPara(n, open + 1, close, current + "(", result);
        }
        if (close < open) {
            generaterPara(n, open, close + 1, current + ")", result);
        }
    }
    /// START : Letter Case Permutation
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
