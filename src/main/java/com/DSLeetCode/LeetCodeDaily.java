package com.DSLeetCode;

import ch.qos.logback.core.joran.sanity.Pair;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class LeetCodeDaily {
    public static void main(String... args) {
        //MinimumCostofBuyingCandiesWithDiscount();
        //CounttheNumberofSpecialCharactersI();
        //CheckifArrayisGood();
        //SeparatetheDigitsinanArray();
        //ExcelSheetColumnTitle();
        //addDigits(38);
        //IntersectionofTwoArraysII();
        //FindtheDifference();
        //AddStrings();
        //ZigzagConversion();
        //PerfectNumber();
        //sortString("aaaabbbbcccc");
        //ReformatTheString();
        //IslandPerimeter();
        //MaxConsecutiveOnes();
        //LargestTriangleArea();
        //ReverseOnlyLetters();
        //SplitaStringinBalancedStrings();
        //uniquenumbers();
    }

    static void ProcessStringwithSpecialOperationsI(){
        StringBuilder sb = new StringBuilder();

    }

    static void uniquenumbers() {
        int[] arr1 = {2, 3, 5, 1};
        int[] arr2 = {4, 3, 5, 1, 9};
        int maxLength = Math.max(arr1.length, arr2.length);
        List<Integer> list = new ArrayList<>();
        int i = 0;
        while (i < maxLength) {
            if (i < arr1.length) if (!list.contains(arr1[i])) list.add(arr1[i]);
            if (i < arr2.length) if (!list.contains(arr2[i])) list.add(arr2[i]);
            i++;
        }
        System.out.println(list);
        list.stream().mapToInt(Integer::intValue).toArray();
    }

    static void SplitaStringinBalancedStrings() {
        String s = "RLRRLLRLRL";
        int ln = 0, rn = 0, total = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'R') rn++;
            else if (s.charAt(i) == 'L') ln++;
            if (ln == rn) {
                total++;
                ln = rn = 0;
            }
        }
        System.out.println("Split a String in Balanced Strings : " + total);
    }

    static void ReverseOnlyLetters() {
        String s = "a-bC-dEf-ghIj";
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                stack.push(c);
            }
        }
        System.out.println("Stack DATA : " + stack);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!(c >= 'a' && c <= 'z') && !(c >= 'A' && c <= 'Z')) {
                sb.append(c);
            } else sb.append(stack.pop());
        }

        System.out.println(sb);
    }

    static void LargestTriangleArea() {
        int[][] points = {{0, 0}, {1, 0}, {0, 1}, {2, 0}, {0, 2}};
        double maxArea = 0.0;
        int n = points.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                for (int k = j + 1; k < n; ++k) {
                    int x1 = points[i][0], y1 = points[i][1];
                    int x2 = points[j][0], y2 = points[j][1];
                    int x3 = points[k][0], y3 = points[k][1];
                    double area = 0.5 * Math.abs(x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        System.out.println("Largest Triangle Area : " + Math.abs(maxArea));
    }


    static void MaxConsecutiveOnes() {
        int[] nums = {1, 1, 0, 1};

        int total = 0;
        int current = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1 && (i == 0 || nums[i - 1] == 1)) {
                current++;
            } else current = 0;
            total = Math.max(total, current);
        }

        System.out.println("Max Consecutive Ones : " + total);
    }

    static void IslandPerimeter() {
        int[][] grid = {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        int perimeter = 0;
        int[][] direction = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    int sides = 4;
                    for (int[] d : direction) {
                        if (i + d[0] >= 0 && i + d[0] < grid.length && j + d[1] >= 0 && j + d[1] < grid[i].length) {
                            if (grid[i + d[0]][j + d[1]] == 1) sides--;
                        }
                    }
                    perimeter += sides;
                }
            }
        }

        System.out.println("IslandPerimeter : " + perimeter);
    }

    static void ReformatTheString() {
        String s = "a0b1c2";
        Queue<Character> pq1 = new PriorityQueue<>();
        Queue<Character> pq2 = new PriorityQueue<>();
        for (char c : s.toCharArray()) {
            if (c >= 48 && c <= 57) pq1.offer(c);
            if (c >= 97 && c <= 122) pq2.offer(c);
        }
        if (Math.abs(pq1.size() - pq2.size()) > 1) return;
        StringBuilder sb = new StringBuilder();
        while (!pq1.isEmpty() || !pq2.isEmpty()) {
            if (pq2.size() > pq1.size()) {
                if (!pq2.isEmpty()) sb.append((char) pq2.poll());
                if (!pq1.isEmpty()) sb.append(pq1.poll() - '0');
            } else {
                if (!pq1.isEmpty()) sb.append(pq1.poll() - '0');
                if (!pq2.isEmpty()) sb.append((char) pq2.poll());
            }
        }
        System.out.println(sb);

    }

    public static String sortString(String s) {
        PriorityQueue<Character> pq = new PriorityQueue();
        for (char c : s.toCharArray())
            pq.offer(c);
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            PriorityQueue<Character> temp = new PriorityQueue(Collections.reverseOrder());
            sb.append(pq.poll());
            while (pq.peek() != null)
                if (pq.peek() <= sb.charAt(sb.length() - 1))
                    temp.offer(pq.poll());
                else
                    sb.append(pq.poll());
            while (!temp.isEmpty()) {
                sb.append(temp.poll());
                while (temp.peek() != null)
                    if (temp.peek() >= sb.charAt(sb.length() - 1))
                        pq.offer(temp.poll());
                    else
                        sb.append(temp.poll());
            }
        }
        return sb.toString();
    }

    static void PerfectNumber() {
        int num = 28;
        int sum = 0;
        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) sum += i;
        }

        System.out.println("Perfect Number : " + sum);
    }

    static void ZigzagConversion() {
        String s = "PAYPALISHIRING";
        int numRows = 3;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < s.length(); j += 2 * (numRows - 1)) {
                sb.append(s.charAt(j));
                if (i > 0 && i < numRows - 1 && j + (2 * (numRows - 1)) - (2 * i) < s.length()) {
                    sb.append(s.charAt(j + (2 * (numRows - 1)) - (2 * i)));
                }
            }
        }
        System.out.println("Zigzag Conversion : " + sb);
    }

    static void AddStrings() {
        String num1 = "11", num2 = "123";
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0 || carry != 0) {
            int d1 = (i >= 0) ? num1.charAt(i) - '0' : 0;
            int d2 = (j >= 0) ? num2.charAt(j) - '0' : 0;
            int sum = d1 + d2 + carry;
            carry = sum / 10;
            sb.append(sum % 10);
            i--;
            j--;
        }

        System.out.println(sb.reverse().toString());
    }

    static void FindtheDifference() {
        System.out.println("Find the Difference in strings by 1 character");
        String s = "abcd", t = "abcde";
        int[] seen = new int[26];

        Arrays.fill(seen, 0);
        for (int i = 0; i < t.length(); i++) {
            seen[t.charAt(i) - 'a']++;
            if (i < s.length()) seen[s.charAt(i) - 'a']--;
        }

        for (int i = 0; i < seen.length; i++) {
            if (seen[i] != 0) {
                System.out.println((char) (i + 'a'));
            }
        }
    }

    static void IntersectionofTwoArraysII() {
        int[] nums1 = {1, 2};
        int[] nums2 = {1, 1};
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        if (nums1.length < nums2.length) {
            int[] nums = nums1;
            nums1 = nums2;
            nums2 = nums;
        }
        int k = 0;
        for (int i = 0, j = 0; i < nums1.length && j < nums2.length; ) {
            if (nums1[i] == nums2[j]) {
                nums1[k] = nums2[j];
                k++;
                j++;
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }
        }

        System.out.println("K : " + k);
        for (int n : Arrays.copyOfRange(nums1, 0, k)) {
            System.out.println(n);
        }
        System.out.println("Intersection of Two Arrays II");
    }

    static public int addDigits(int num) {
        int sum = num;
        while (sum > 9) {
            int s = 0;
            for (char c : String.valueOf(sum).toCharArray()) {
                s += Character.getNumericValue(c);
            }
            sum = s;
        }
        System.out.println("Add Digits : " + sum);
        return sum;
    }

    static void ExcelSheetColumnTitle() {
        int columnNumber = 701;
        StringBuilder ans = new StringBuilder("");
        while (columnNumber > 0) {
            columnNumber--;
            // Get the last character and append it at the end of the string.
            ans.append((char) (((columnNumber) % 26) + 'A'));
            columnNumber = (columnNumber) / 26;
        }

        System.out.println("Excel Sheet Column Title : " + ans.reverse());
    }

    static void LeftandRightSumDifferences() {
        int[] nums = {10, 4, 8, 3};
        int[] leftSum = new int[nums.length];
        int[] rightSum = new int[nums.length];
        Arrays.fill(leftSum, 0);
        Arrays.fill(rightSum, 0);
        for (int i = 1, j = nums.length - 2; i < nums.length || j >= 0; i++, j--) {
            leftSum[i] = leftSum[i - 1] + nums[i - 1];
            rightSum[j] = rightSum[j + 1] + nums[j + 1];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = Math.abs(leftSum[i] - rightSum[i]);
        }

        System.out.println("Left and Right Sum Differences : ");
    }

    static void SeparatetheDigitsinanArray() {
        int[] nums = {13, 25, 83, 77};
        List<Integer> list = new ArrayList<>();

        for (int num : nums) {
            String n = String.valueOf(num);
            for (char c : n.toCharArray()) {
                list.add(Character.getNumericValue(c));
            }
        }
        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        System.out.println("Separate the Digits in an Array : " + list);
    }

    static boolean CheckifArrayisGood() {
        int[] nums = {1, 3, 3, 2};
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i != n - 1 && nums[i] != i + 1) return false;
            if (i == n - 1 && nums[i] != n - 1) return false;
        }
        return true;
    }

    static void CounttheNumberofSpecialCharactersI() {
        String word = "BBbab";
        int[] lower = new int[26];
        int[] upper = new int[26];

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c >= 'a' && c <= 'z') lower['z' - c]++;
            if (c >= 'A' && c <= 'Z') upper['Z' - c]++;
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (lower[i] != 0 && upper[i] != 0) count += (Math.min(Math.min(lower[i], upper[i]), 1));
        }
        System.out.println("Count the Number of Special Characters I : " + count);
    }

    static void MinimumCostofBuyingCandiesWithDiscount() {
        int[] cost = {3, 3, 3, 1};
        Arrays.sort(cost);
        int n = cost.length;
        int sum = 0;
        if (n <= 2) {
            for (int c : cost) {
                sum += c;
            }
        }

        int i = n - 1;
        for (; i >= 0; i = i - 3) {
            if (i > 0) sum += cost[i] + cost[i - 1];
            else sum += cost[i];
        }

        System.out.println("Minimum Cost of Buying Candies With Discount : " + sum);
    }
}
