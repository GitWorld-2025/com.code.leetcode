package com.Blind75;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LeetCode_1P {
    public static void main(String[] args) {
        //findLongestValidSubString();
        //validParanthesisCaller();
        //findPlusOne();
        //fourDivisors();
        //findIndexesOfSubArraySum();
        //System.out.println(reverseStringRecursion("abcdefg"));
        //fizzBizz();
        //searchInRotatedArray();
        //circularMaxSumSubarray();
        //longestSubstringWithoutRepeatingCharacter();
        //uniqueNumber2();
        //rotateArraybyKelements();
        //IntersectionofwoArrays();
        //maximumContinousSubArray();
        //isOverlappingCaller();
        //minimum_Absolute_Difference();
        //mergeTwoSortedArray();
        //containerWithMostWater();
        //rangeSumQueryImmutable();
        //productExceptSelf();
        //seperateDistinctArray();
        //seperateDistinctArray2Pointers();
        findListOfPalindrom();
    }

    static void findListOfPalindrom(){
        String s = "okko";
        List<String> result = new ArrayList<>();

        for(int i = 0; i < s.length();i++){
            for(int j = i; j <= s.length();j++){
                String sub = s.substring(i,j);
                if(checkPalindrom(sub) && !sub.isEmpty()) result.add(s.substring(i,j));
            }
        }
        for(String s1 : result) System.out.println(s1);
    }
    static boolean checkPalindrom(String str){
        return IntStream.range(0, str.length() / 2).noneMatch(i -> str.charAt(i) != str.charAt(str.length() - i - 1));
    }

    static void seperateDistinctArray2Pointers() {
        /// Pending
        int[] arr = {1, 2, 2, 3, 4, 4, 4, 5, 5};
        int sorted = 0;
        int pointer = 1;
        while (pointer < arr.length && sorted < arr.length - 1) {
            if (arr[sorted + 1] > arr[sorted]) {
                sorted++;
                pointer = sorted + 1;
                continue;
            }
            if (arr[sorted + 1] != arr[pointer]) {
                int temp = arr[pointer];
                arr[pointer] = arr[sorted + 1];
                arr[sorted + 1] = temp;
                sorted++;
            }
            pointer++;
        }

        for (int num : arr) {
            System.out.println(num);
        }
    }

    static void seperateDistinctArray() {
        int[] arr = {1, 2, 2, 3, 4, 4, 4, 5, 5};
        int[] result = new int[arr.length];
        int[] duplicate = new int[arr.length];
        result[0] = arr[0];
        int j = 1, k = 0;
        for (int i = 1; i < arr.length; i++) {
            if (result[j - 1] == arr[i]) {
                duplicate[k] = arr[i];
                k++;
            } else {
                result[j] = arr[i];
                j++;
            }
        }
        k = 0;
        while (j < result.length) {
            result[j] = duplicate[k];
            j++;
            k++;
        }
        for (int num : result) {
            System.out.println(num);
        }
    }

    public static void productExceptSelf() {
        int[] nums = {-1, 1, 0, -3, 3};
        boolean hasZero = Arrays.stream(nums).anyMatch(i -> i == 0);
        int countZero = (int) Arrays.stream(nums).filter(i -> i == 0).count();
        int maxresult = Arrays.stream(nums).filter(i -> i != 0).reduce(1, (a, b) -> a * b);
        int[] array = Arrays.stream(nums).map(i -> {
                    if (i == 0) {
                        if (countZero > 1) return 0;
                        else return maxresult;
                    } else {
                        if (hasZero) return 0;
                        else return maxresult / i;
                    }
                })
                .toArray();
        for (int num : array) System.out.println(num);
    }

    static void rangeSumQueryImmutable() {
        int left = 2;
        int right = 5;
        int[] nums = {-2, 0, 3, -5, 2, -1};
        int leftSum = 0;
        int totalSum = 0;
        for (int i = 0; i <= right; i++) {
            if (i < left) leftSum = leftSum + nums[i];
            totalSum = totalSum + nums[i];
        }
        System.out.println(totalSum - leftSum);
    }

    static void containerWithMostWater() {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int i = 0;
        int j = height.length - 1;
        int maxHeight = 0;
        while (i < j) {
            if (height[i] > height[j]) {
                maxHeight = Math.max(maxHeight, height[j] * (j - i));
                j--;
            } else {
                maxHeight = Math.max(maxHeight, height[i] * (j - i));
                i++;
            }
        }
        System.out.println(maxHeight);
    }

    static void mergeTwoSortedArray() {
        int[] nums1 = new int[7];
        int[] nums2 = {3, 5, 7};

        nums1[0] = 1;
        nums1[1] = 2;
        nums1[2] = 4;
        nums1[3] = 6;
        int i = 2;
        int j = 3;
        int k = 6;
        for (; k >= 0 && i >= 0 && j >= 0; k--) {
            if (nums2[i] > nums1[j]) {
                nums1[k] = nums2[i];
                i--;
            } else {
                nums1[k] = nums1[j];
                j--;
            }
        }

        for (int num : nums1) System.out.println(num);
    }

    static void minimum_Absolute_Difference() {
        int[] arr = {1, 3, 6, 10, 15};
        int minDiff = Integer.MAX_VALUE;
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        for (int i = 1; i < arr.length; i++) {
            if (minDiff > arr[i] - arr[i - 1]) minDiff = arr[i] - arr[i - 1];
        }
        for (int i = 1; i < arr.length; i++) {
            if (minDiff == arr[i] - arr[i - 1]) {
                int finalI = i;
                List<Integer> ls = new ArrayList<>() {{
                    add(arr[finalI - 1]);
                    add(arr[finalI]);
                }};
                result.add(ls);
            }
        }
        result.stream().forEach(System.out::println);
    }

    static void isOverlappingCaller() {
        Rectangle rec1 = new Rectangle(new Point(0, 0), new Point(1, 1));
        Rectangle rec2 = new Rectangle(new Point(1, 0), new Point(2, 1));
        System.out.println(isOverlapping(rec1, rec2));
    }

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Rectangle {
        Point l;
        Point r;

        Rectangle(Point l, Point r) {
            this.l = l;
            this.r = r;
        }
    }

    static boolean isOverlapping(Rectangle r1, Rectangle r2) {
        if (r2.l.x > r1.r.x || r1.l.x > r2.r.x) return false;
        if (r2.l.y > r1.r.y || r1.l.y > r2.r.y) return false;

        return true;
    }

    static void maximumContinousSubArray() {
        int[] nums = {4, 1, 3, -6, 7, 1, -2, 5};
        int maxSum = 0;
        int currSum = 0;

        for (int num : nums) {
            currSum = Math.max(currSum + num, num);
            maxSum = Math.max(maxSum, currSum);
        }
        System.out.println("Maximum sum of subaaray : " + maxSum);
    }

    static void IntersectionofwoArrays() {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        Set<Integer> set = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }
        Set<Integer> collect = Arrays.stream(nums2).boxed().filter(num -> set.contains(num)).collect(Collectors.toSet());

        int[] result = collect.stream().mapToInt(Integer::intValue).toArray();
    }

    static void rotateArraybyKelements() {
        Integer[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        Arrays.sort(nums, Collections.reverseOrder());
        Arrays.sort(nums, 0, k);
        Arrays.sort(nums, k, nums.length);

        Arrays.stream(nums).forEach(System.out::println);
    }

    static void uniqueNumber2() {
        int[] nums = {1, 3, 5, 3, 2, 1};
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        int setBit = xor & (-xor);

        int x = 0;
        int y = 0;

        for (int num : nums) {
            if ((num & setBit) == 0) x ^= num;
            else y ^= num;
        }
        System.out.println("X : " + x);
        System.out.println("Y : " + y);
    }

    static void longestSubstringWithoutRepeatingCharacter() {
        String str = "abcbadbd";
        boolean[] sub = new boolean[26];
        int left = 0, right = 0;
        int maxSub = 0;
        while (right < str.length() - 1) {
            while (sub[str.charAt(right) - 'a'] == true) {
                sub[str.charAt(left) - 'a'] = false;
                left++;
            }
            sub[str.charAt(right) - 'a'] = true;
            maxSub = Math.max(maxSub, right - left + 1);
            right++;
        }
        System.out.println("Longest Substring Without Repeating Character : " + maxSub);
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

    static void searchInRotatedArray() {
        int[] nums = {5, 6, 7, 8, 9, 10, 11, 12, 1, 2, 3, 4};
        int low = 0;
        int high = nums.length - 1;
        int target = 4;
        boolean flag = false;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (target == nums[mid]) {
                flag = true;
                break;
            } else if (nums[low] <= nums[mid]) {
                if (target <= nums[mid] && target >= nums[low]) high = mid - 1;
                else low = mid + 1;
            } else {
                if (target >= nums[mid] && target <= nums[high]) low = mid + 1;
                else high = mid - 1;
            }
        }
        System.out.println("Existance of target in List : " + flag);
    }

    static void fizzBizz() {
        int count3 = 0, count5 = 0;
        for (int i = 0; i <= 20; i++) {
            if (count3 == 3 && count5 == 5) {
                System.out.println("FizzBuzz");
                count3 = 0;
                count5 = 0;
            } else if (count3 == 3) {
                System.out.println("Fizz");
                count3 = 0;
            } else if (count5 == 5) {
                System.out.println("Buzz");
                count5 = 0;
            } else {
                System.out.println(i);
            }
            count3++;
            count5++;
        }
    }

    static String reverseStringRecursion(String str) {
        if (str == null || str.length() <= 1) return str;
        return reverseStringRecursion(str.substring(1)) + str.charAt(0);
    }

    static void findIndexesOfSubArraySum() {
        int[] nums = {1, 2, 3, 7, 5};
        int target = 12;
        int i = 0;
        int j = nums.length - 1;
        boolean flag = false;
        //Arrays.sort(nums);
        while (i <= j) {
            int diff = target - nums[j];
            if (diff == nums[i]) {
                flag = true;
                break;
            }
            if (diff > nums[i]) i++;
            else if (diff < nums[j]) j--;
        }
        if (flag) System.out.println("Elements found at - i : " + i + "  || j : " + j);
        else System.out.println("Elements not found");
    }

    static void validTriangles() {
        int[] nums = {2, 2, 4, 5, 5, 6, 7};
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        // Pending

    }

    static void fourDivisors() {
        int[] num = {21, 21};

        List<List<Integer>> list = Arrays.stream(num).boxed().map(i -> findDivisors(i)).toList();
        Integer reduce = list.stream().filter(ls -> ls.size() == 4)
                .flatMap(Collection::stream).reduce(0, Integer::sum);
        System.out.println("Total sum : " + reduce);
    }

    static List<Integer> findDivisors(int num) {
        //int num = 21;
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                if (num / i == i) {
                    list.add(i);
                } else {
                    list.add(i);
                    list.add(num / i);
                }
            }
        }
        return list;
    }

    static void findPlusOne() {
        int[] digits = {1, 2, 3};
        int takeOne = 0;

        for (int i = digits.length - 1; i >= 0; i--) {
            if (i == digits.length - 1) digits[i] = digits[i] + 1;
            digits[i] = digits[i] + takeOne;
            takeOne = 0;
            int temp = digits[i];
            if (temp >= 10) {
                digits[i] %= 10;
                takeOne = +1;
            } else break;
        }
        if (takeOne == 1) {
            int[] result = IntStream.concat(Arrays.stream(new int[]{1}), Arrays.stream(digits)).toArray();
            Arrays.stream(result).boxed().forEach(System.out::println);
        }

        //Arrays.stream(digits).boxed().forEach(System.out::println);
    }

    static void validParanthesisCaller() {
        if (validParanthesis()) {
            System.out.println("Valid Paranthesis");
        } else {
            System.out.println("Invalid Paranthesis");
        }
    }

    static boolean validParanthesis() {
        String str = "{[]}({}{})";
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[') stack.push(ch);
            if (stack.isEmpty()) return false;

            char check;
            switch (ch) {
                case ')':
                    check = stack.pop();
                    if (check == '{' || check == '[')
                        return false;
                    break;
                case '}':
                    check = stack.pop();
                    if (check == '(' || check == '[')
                        return false;
                    break;
                case ']':
                    check = stack.pop();
                    if (check == '(' || check == '{')
                        return false;
                    break;
            }
        }
        return stack.empty();
    }

    static void equlibriumIndex() {
        int[] nums = {-1, -1, 0, 1, 1, 0};
        //int[] nums = {1,7,3,6,5,6};
        int totalSum = Arrays.stream(nums).sum();
        int leftSum = 0;
        int pivote = -1;
        for (int i = 0; i < nums.length; i++) {
            int rightSum = totalSum - leftSum - nums[i];
            if (leftSum == rightSum) {
                pivote = i;
                break;
            }
            leftSum += nums[i];
        }
        System.out.println(pivote);
    }

    static void findUniqueElementinArray() {
        int[] arr = {1, 2, 2, 1, 3};
        int xor = 0;
        for (int num : arr) {
            xor ^= num;
            System.out.println(xor);
        }
        System.out.println("Result : " + xor);
    }

    static void mergeTwoSorteArrays() {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int m = 3, n = 3;

        int midx = m - 1;
        int nidx = n - 1;
        int right = m + n - 1;

        while (nidx >= 0) {
            if (midx >= 0 && nums1[midx] > nums2[nidx]) {
                nums1[right] = nums1[midx];
                midx--;
            } else {
                nums1[right] = nums2[nidx];
                nidx--;
            }
            right--;
        }

        for (int num : nums1) {
            System.out.println(num);
        }
    }

    static void removeDuplcatesFromSortedArray() {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int nonDplicateElements = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] != nums[i]) {
                nums[nonDplicateElements] = nums[i];
                nonDplicateElements++;
            }
        }
        System.out.println(nonDplicateElements);

    }

    static void moveZerosAtEndInArray() {
        int[] nums = {0, 1, 0, 3, 12, 0};

        for (int i = 0, j = 0; i < nums.length && j < nums.length; ) {
            if (nums[j] != 0) {
                swap(nums, i, j);
                i++;
                j++;
            } else j++;
        }
        for (int num : nums) {
            System.out.println(num);
        }
    }

    static void findMajarityElement() {
        //Majority element is nums length n , element appears > n/2
        //simplest sort elements find mid n/2 element
        //Expected find votes of majority
        int[] nums = {7, 7, 5, 7, 5, 1, 2, 7, 7};
        int votes = 0;
        int candidate = -1;
        for (int i = 0; i < nums.length; i++) {
            if (votes == 0) {
                candidate = nums[i];
                votes++;
            } else if (candidate == nums[i]) {
                votes++;
            } else votes--;
        }
        System.out.println(candidate);
    }

    static void sortArrayIncreasingFrquency() {
        int[] nums = {2, 3, 1, 3, 2};
        Map<Integer, Integer> map = new HashMap<>();
        Integer[] newNums = new Integer[nums.length];

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            newNums[i] = nums[i];
        }
        Arrays.sort(newNums, (a, b) -> {
            int freqCompare = map.get(a) - map.get(b);
            return freqCompare != 0 ? freqCompare : b - a;
        });
        for (int num : newNums) {
            System.out.println(num);
        }
    }

    public static void sortArrayInWaveForm() {
        int[] nums = {2, 5, 6, 7, 4, 1};
        for (int i = 1; i < nums.length; i += 2) {
            if (i < nums.length - 1 && nums[i] < nums[i + 1])
                swap(nums, i, i + 1);
            else if (nums[i] < nums[i - 1]) {
                swap(nums, i, i - 1);
            }
        }
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public static void findMissingNumber() {
        int[] nums1 = {9, 6, 4, 2, 3, 5, 7, 1};
        //using Guase
        int expectedSum = 0, actualSum = 0;
        for (int i = 0; i < nums1.length; i++) {
            expectedSum += i;
            actualSum += nums1[i];
        }
        System.out.println("Missing no. using Guass : " + (actualSum - expectedSum));

        //Using Xor
        int[] nums = {9, 6, 4, 2, 3, 5, 7, 1, 0};
        int xor = 0;
        int n = nums.length;
        for (int i = 0, j = 0; i <= n; i++) {
            if (j < nums.length) {
                xor = xor ^ i ^ nums[i];
                j++;
            } else {
                xor = xor ^ i;
            }
        }
        System.out.println("Missing no. using XOR : " + xor);
    }

    static void sort012inUnsortedArrayOptimalDNFAlgo() {
        int[] nums = {0, 2, 0, 2, 1, 1, 0, 2, 1, 2, 0, 2, 0, 1, 1, 2};
        // 0s- 0 to l-1
        // 1s- l to m-1
        // 2s- m to h-1
        int low = 0, mid = 0, high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, high);
                high--;
            }

        }
        for (int num : nums) {
            System.out.println(num);
        }

    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    static void sort012inUnsortedArrayBruteForce() {
        int[] nums = {0, 2, 0, 2, 1, 1, 0, 2, 1, 2, 0, 2, 0, 1, 1, 2};
        Map<Integer, Integer> numMap = new TreeMap<>();
        for (int num : nums) {
            numMap.putIfAbsent(num, 0);
            numMap.computeIfPresent(num, (k, v) -> v + 1);
        }
        System.out.println(numMap);

        for (int i = 0; i < nums.length; i++) {
            for (Map.Entry e : numMap.entrySet()) {
                for (int j = 0; j < (int) e.getValue(); j++) {
                    nums[i] = (int) e.getKey();
                    i++;
                }
            }
        }
        for (int num : nums) {
            System.out.println(num);
        }
    }

    static void findLongestValidSubString() {
        //Pending
        String word = "cbaaaabc";
        String[] forbidden = {"aaa", "cb"};

        int max = -1;
        StringBuilder result = new StringBuilder();
        for (int i = 0, j = word.length(); i < word.length() && j > 0; i++, j--) {
            String str1 = word.substring(i, word.length());
            String str2 = word.substring(0, j);
            boolean flag = true;
            for (String s : forbidden) {

            }
            System.out.println("Max length : " + max);
            System.out.println("Substring : " + result);
        }
    }

    static void findKthLargestElementWithoutSorting() {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < k; i++) {
            queue.add(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            if (nums[i] > queue.peek()) {
                queue.poll();
                queue.add(nums[i]);
            }
        }
        System.out.println(queue);
    }

    static void mergeIntervelsBruteforce() {
        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};
        List<int[]> list = new ArrayList<>(Arrays.asList(intervals));
        list.add(newInterval);
        list = list.stream()
                .sorted(Comparator.comparingInt(a -> a[0]))
                .collect(Collectors.toList());
        List<int[]> res = new ArrayList<>();
        res.add(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            int[] last = res.get(res.size() - 1);
            int[] curr = list.get(i);
            if (curr[0] <= last[1]) {
                last[1] = Math.max(curr[1], last[1]);
            } else
                res.add(curr);
        }
        //res.stream().toArray(int[][]::new);
        res.forEach(arr -> System.out.println(Arrays.toString(arr)));
    }

    public int longestConsecutive(int[] nums) {
        if (nums == null) return 0;
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        nums = Arrays.stream(nums).distinct().toArray();
        int maxLen = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            int currentLen = 1;
            if (nums[i] + 1 == nums[i + 1]) {
                while (i < nums.length - 1 && nums[i] + 1 == nums[i + 1]) {
                    currentLen += 1;
                    i++;
                }
            }
            maxLen = Math.max(maxLen, currentLen);
        }
        return maxLen;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) return new ArrayList<>();
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    List<Integer> ls = new ArrayList<>();
                    ls.add(nums[i]);
                    ls.add(nums[left]);
                    ls.add(nums[right]);
                    res.add(ls);
                    right--;
                    left++;
                }
                if (sum > 0) right -= 1;
                else left += 1;
            }
        }
        return res;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0 || strs == null) return new ArrayList<>();
        Map<String, List<String>> frequencyMap = new HashMap<>();

        for (String str : strs) {
            String frequencyStr = getFrequency(str);
            if (frequencyMap.containsKey(frequencyStr)) {
                frequencyMap.get(frequencyStr).add(str);
            } else {
                frequencyMap.put(frequencyStr, new ArrayList<String>() {{
                    add(str);
                }});
            }
        }
        return new ArrayList<>(frequencyMap.values());
    }

    String getFrequency(String str) {
        int[] freq = new int[26];
        for (char c : str.toCharArray()) {
            freq[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        char c = 'a';
        for (int i : freq) {
            sb.append(c);
            sb.append(i);
            c++;
        }
        return sb.toString();
    }

    static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        int sum = 0;
        int[] res = new int[2];
        while (left <= right) {
            sum = numbers[left] + numbers[right];
            if (sum == target) {
                res[0] = left;
                res[1] = right;
                return res;
            }
            if (sum > target) right -= 1;
            else left += 1;
        }
        return res;
    }

    static void serchinRotatedSortedArray() {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                System.out.println("Target found at index: " + mid);
                return;
            }
            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        System.out.println("Target not found");
    }

    static int findMininRotatedSortedArray() {
        int[] nums = {3, 4, 5, 1, 2};
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left < right) {
            if (nums[left] < nums[right]) return nums[left];
            mid = left + (right - left) / 2;
            if (nums[mid] >= nums[left]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }

    static public void maxProduct() {
        int[] nums = {2, 3, -2, 4};
        int maxProduct = nums[0];
        int minProduct = nums[0];
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = maxProduct;
                maxProduct = minProduct;
                minProduct = temp;
            }
            maxProduct = Math.max(nums[i], maxProduct * nums[i]);
            minProduct = Math.min(nums[i], minProduct * nums[i]);
            result = Math.max(result, maxProduct);
        }
        System.out.println("Maximum product subarray is: " + result);
    }

    static public void maxSubArray() {
        int[] nums = {5, 4, -1, 7, 8};
        int maxSoFar = nums[0];
        int maxEndingHere = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        System.out.println("Maximum subarray sum is: " + maxSoFar);
    }

    static void productofarrayexceptself() {
        int[] nums = {1, 2, 0, 3, 4};
        boolean hasZero = Arrays.stream(nums).anyMatch(i -> i == 0);
        int countZero = (int) Arrays.stream(nums).filter(i -> i == 0).count();
        int maxresult = Arrays.stream(nums).filter(i -> i != 0).reduce(1, (a, b) -> a * b);
        int[] array = Arrays.stream(nums).map(i -> {
                    if (i == 0) {
                        if (countZero > 1) return 0;
                        else return maxresult;
                    } else {
                        if (hasZero) return 0;
                        else return maxresult / i;
                    }
                })
                .toArray();
        System.out.println(Arrays.toString(array));
    }

    static void bestTimetobuuyandsellstock() {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (minPrice > prices[i]) {
                minPrice = prices[i];
            } else {
                int profit = prices[i] - minPrice;
                maxProfit = Math.max(maxProfit, profit);
            }
        }
        System.out.println("Max Profit: " + maxProfit);
    }

    static void twoSumProblem() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                System.out.println("Indices: " + map.get(complement) + ", " + i);
                return;
            } else {
                map.put(nums[i], i);
            }
        }
    }
}
