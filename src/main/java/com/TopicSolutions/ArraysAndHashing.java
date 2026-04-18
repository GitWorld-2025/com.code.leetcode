package com.TopicSolutions;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArraysAndHashing {
    public static void main(String... args) {
        //ContainsDuplicate();
        //ValidAnagram();
        //TwoSum();
        //GroupAnagrams();
        //TopKFrequentElements();
        //StringEncodeAndDecodeCaller();
        //ProductsofArrayExceptSelf();LongestCommonPrefix
        //LongestCommonPrefix();
        //RemoveDuplicatesfromSortedArray();
        //RemoveDuplicatesfromSortedArrayII();
        //CheckIfItIsaStraightLine();
        //FirstMissingPositive();
        //uglyNumber();
        //permutationStringusingHashMap();
        //AddtoArrayFormofInteger();
        RemoveOutermostParentheses();
    }

    static void RemoveOutermostParentheses() {
        String s = "(()())(())";
        StringBuilder sb = new StringBuilder();
        int open = 0;
        for(char c : s.toCharArray()){
            if(c == '(' && open++ > 0) sb.append(c);
            if(c == ')' && open-- > 1) sb.append(c);
        }
        System.out.println(sb);
    }

    static void AddtoArrayFormofInteger() {
        int[] num = {2, 1, 5};
        int k = 806;
        List<Integer> result = new ArrayList<>();
        int i = num.length - 1;

        while (i >= 0 || k > 0) {
            int sum = (i >= 0 ? num[i] : 0) + k;
            result.add(sum % 10);
            k = sum / 10;
            i--;
        }
        //result.reversed();
        Collections.reverse(result);
        result.forEach(System.out::println);
    }

    static boolean permutationStringusingHashMap() {
        String s1 = "adc";
        String s2 = "dcda";
        Map<Character, Integer> count1 = new HashMap<>();
        for (char c : s1.toCharArray()) {
            count1.put(c, count1.getOrDefault(c, 0) + 1);
        }

        int need = count1.size();
        for (int i = 0; i < s2.length(); i++) {
            Map<Character, Integer> count2 = new HashMap<>();
            int cur = 0;
            for (int j = i; j < s2.length(); j++) {
                char c = s2.charAt(j);
                count2.put(c, count2.getOrDefault(c, 0) + 1);

                if (count1.getOrDefault(c, 0) < count2.get(c)) {
                    break;
                }

                if (count1.getOrDefault(c, 0) == count2.get(c)) {
                    cur++;
                }

                if (cur == need) {
                    return true;
                }
            }
        }
        return false;
    }

    static void uglyNumber() {
        int n = 5;
        int[] factors = {2, 3, 5};
        boolean flag = false;

        for (int factor : factors) {
            if (n == 1) {
                flag = true;
                break;
            }
            while (n % factor == 0) {
                n = n / factor;
            }
        }

        System.out.println("Ugly Number : " + flag);
    }

    static void FirstMissingPositive() {
        /// USING Cycle Sort
        int[] nums = {1, 7, 8, 9, 11, 12};
        int n = nums.length;
        boolean[] seen = new boolean[n + 1];

        for (int num : nums) {
            if (num > 0 && num <= n) {
                seen[num] = true;
            }
        }
        int i = 1;
        for (; i < seen.length; i++) {
            if (!seen[i]) {
                break;
            }
        }
        System.out.println("FirstMissingPositive : " + i);

        /*int i = 0;
        while (i < nums.length) {
            int ci = nums[i] - 1;
            if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[ci]) {
                int temp = nums[i];
                nums[i] = nums[ci];
                nums[ci] = temp;
            } else if (nums[i] > 0 && ci <= nums.length) {
                nums[ci] = nums[i];
                i++;
            } else i++;
        }
        int result = 0;
        for (int j = 0; j < nums.length; j++) {
            if (j + 1 != nums[j]) {
                result = j + 1;
                break;
            }
        }
        System.out.println(result);*/
    }

    static void CheckIfItIsaStraightLine() {
        int[][] coordinates = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}};
        //(y2-y1)(x3-x2) = (x2-x1)(y3-y2)
        boolean flag = true;
        int x1 = coordinates[0][0];
        int y1 = coordinates[0][1];
        int x2 = coordinates[1][0];
        int y2 = coordinates[1][1];
        for (int i = 2; i < coordinates.length; i++) {

            if ((y2 - y1) * (coordinates[i][0] - x2) != (x2 - x1) * (coordinates[i][1] - y2)) {
                flag = false;
            }
        }
        System.out.println("Check If It Is a Straight Line : " + flag);
    }

    static void RemoveDuplicatesfromSortedArrayII() {
        int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        int count = 0;
        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                count = 0;
            }

            if (count <= 1) {
                nums[index] = nums[i];
                index++;
            }
        }
    }

    static void RemoveDuplicatesfromSortedArray() {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] != nums[i]) {
                nums[count] = nums[i];
                count++;
            }
        }
        System.out.println("No of Distinct numbers after RemoveDuplicatesfromSortedArray : " + count);
    }

    static void LongestCommonPrefix() {
        String[] str = {"flower", "flow", "flight"};

        String s = new String(str[0]);

        for (int i = 1; i < str.length; i++) {
            while (str[i].indexOf(s) != 0) {
                s = s.substring(0, s.length() - 1);
                if (s.length() == 0) {
                    s = "";
                    break;
                }

            }
        }
        System.out.println("Longest Common Prefix : " + s);

    }

    static void LongestConsecutiveSequence() {
        int[] nums = {2, 20, 4, 10, 3, 4, 5};
        int[] result = new int[nums.length];

        /// USING TreeSet
        int maxLength2 = 1;
        int temp = 1;
        int prev = -1;
        Set<Integer> set = new TreeSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int num : set) {
            if (num - prev == 1) {
                temp++;
                maxLength2 = Math.max(maxLength2, temp);
            } else temp = 1;
            prev = num;
        }
        System.out.println("Longest Consecutive Sequence MaxLength using TreeSet : " + maxLength2);
    }

    static void ProductsofArrayExceptSelf() {
        int[] nums = {-1, 0, 0, 2, 3};
        int[] result = new int[nums.length + 1];
        int totalProduct = 1;
        int zeroCount = 0;
        //Arrays.fill(result,0);

        for (int num : nums) {
            if (num == 0) zeroCount++;
            else totalProduct *= num;
        }
        if (zeroCount > 1) return;
        for (int i = 0; i < nums.length; i++) {
            if (zeroCount == 1) {
                if (nums[i] == 0) result[i] = totalProduct;
                else result[i] = 0;
            } else result[i] = totalProduct / nums[i];

        }
        for (int num : result) System.out.println(num);
    }

    static void StringEncodeAndDecodeCaller() {
        List<String> strs = Arrays.asList("Hello", "World");
        System.out.println(decode(encode(strs)));
    }

    public static String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (String str : strs) {
            sb.append(str.length()).append("#").append(str);
        }
        return sb.toString();
    }

    public static List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));
            i = j + 1;
            j = i + length;
            result.add(str.substring(i, j));
            i = j;
        }

        return result;
    }

    static void TopKFrequentElements() {
        int[] nums = {1, 2, 2, 3, 3, 3};
        int k = 2;
        int[] result = new int[k];

        List<Integer>[] bucket = new List[nums.length + 1];
        for (int b = 0; b < bucket.length; b++) bucket[b] = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            bucket[entry.getValue()].add(entry.getKey());
        }

        for (int i = bucket.length - 1, j = 0; i > 0 && j < k; i--) {
            if (!bucket[i].isEmpty()) {
                for (int num : bucket[i]) {
                    result[j] = num;
                    j++;
                    if (j == k) break;
                }
            }
        }
        for (int n : result) System.out.println(n);
    }

    static void GroupAnagrams() {
        String[] strs = {"act", "pots", "tops", "cat", "stop", "hat"};
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String strSorted = Arrays.stream(str.split("")).sorted(Comparator.naturalOrder()).collect(Collectors.joining());
            if (map.containsKey(strSorted)) {
                map.get(strSorted).add(str);
            } else map.put(strSorted, new ArrayList<>() {{
                add(str);
            }});
        }
        List<List<String>> collect = map.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());
        System.out.println(collect);
    }

    static void TwoSum() {
        int[] nums = {3, 4, 5, 6};
        int target = 2;
        int left = 0, right = nums.length - 1;
        boolean flag = false;

        while (left <= right) {
            if (target == nums[right] + nums[left]) {
                flag = true;
                break;
            } else if (target > (nums[right]) + nums[left]) {
                left++;
            } else right--;
            ;
        }
        System.out.println(flag);
    }

    static void ValidAnagram() {
        String s = "anagrar", t = "nagaram";
        ///  using streams
        boolean equals = Arrays.stream(s.split("")).sorted(Comparator.naturalOrder()).collect(Collectors.joining())
                .equals(Arrays.stream(t.split("")).sorted(Comparator.naturalOrder()).collect(Collectors.joining()));
        //System.out.println(equals);

        /// using Array
        int[] checked = new int['z' + 1];
        for (int i = 0; i < s.length(); i++) {
            if (checked[s.charAt(i)] == 0) {
                checked[s.charAt(i)]++;
            } else checked[s.charAt(i)]--;
            if (checked[t.charAt(i)] == 0) {
                checked[t.charAt(i)]++;
            } else checked[t.charAt(i)]--;
        }
        boolean flag = true;
        for (int num : checked) if (num != 0) flag = false;
        System.out.println("Valid Anagram : " + flag);

    }

    static void ContainsDuplicate() {
        int[] nums = {1, 5, -2, -4, 0};
        Set<Map.Entry<Integer, Long>> collect = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(entry -> entry.getValue() > 1).collect(Collectors.toSet());
        System.out.println(collect.size() > 0);

        /// 2nd Approch
        boolean flag = false;
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num)) {
                flag = true;
            }
            seen.add(num);
        }
        flag = false;
    }
}
