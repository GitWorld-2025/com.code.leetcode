package com.JavaStreamAPI;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JavaStreamCode {
    public static void main(String... args) {
        //findFirstNonRepeatingCharacter();
        //findMaxFrequencyOfFirst2Numbers();
        //frequencyOfWordGroup();
        //seperateOddAndEvenNumbers();
        //findFrequencyOfEachCharacter();
        //sortListinReverseOrder();
        //merge2UnsortedArrayinOneSortedArray();
        //minmax3NumsFromList();
        //listOfStringWithIncreasingLength();
        //checkPalindromeUsingStream();
        //findLastElementOfArray();
        //findAgeUingDateUtil();
        //removeDuplicateElementsFromLit();
        //findFrequencyOfEachElementInArray();
        //joinStringsListWithPrefixDelimiterSuffix();
        //findMaximumandMinimuminList();
        //checkIfAnagram();
        //findSumOfAllDigitsOfNumber();
        //findSecondLargestNumFromIntegerArray();
        //findCommonElementsBetween2Arrays();
        //reverseEachWordOfString();
        //findStringsFromListStartsWithDigits();
        //findDuplicateElementsFromArray();
        //fibonacciSeries();
        //printReleaseSummary();
        permutationStringUsingStreams();
    }

    static void permutationStringUsingStreams() {
        String s1 = "adc";
        String s2 = "dcda";
        boolean flag = false;
        for(int i = 0 ; i < s2.length() - s1.length()+1;i++){
            flag = Arrays.stream(s2.substring(0+i, s1.length()+i).split("")).sorted().collect(Collectors.joining())
                    .contains(Arrays.stream(s1.split("")).sorted().collect(Collectors.joining()));
            if(flag) break;
        }
        System.out.println(flag);
    }
    static void printReleaseSummary() {
        List<List<String>> data = new ArrayList<>();
        data.add(new ArrayList<>() {{
            add("01/02/2020");
            add("1.0.0");
            add("initial release");
        }});
        data.add(new ArrayList<>() {{
            add("20/10/2024");
            add("4.0.0");
            add("4.x release");
        }});
        data.add(new ArrayList<>() {{
            add("10/05/2025");
            add("3.8.10");
            add("patch release");
        }});


        Comparator<List<String>> releaseComparator = (a, b) -> {
            String[] aVarr = a.get(1).split("\\.");
            String[] bVarr = b.get(1).split("\\.");
            int length = Math.max(aVarr.length, bVarr.length);
            for (int i = 0; i < length; i++) {
                int aV = i < aVarr.length ? Integer.parseInt(aVarr[i]) : 0;
                int bV = i < bVarr.length ? Integer.parseInt(bVarr[i]) : 0;
                if (aV > bV) return 1;
                if (bV > aV) return -1;
            }
            return 0;
        };

        data.sort(releaseComparator);
        System.out.println("Release Comparator : ");
        data.stream().forEach(System.out::println);

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Comparator<List<String>> dateComparator = (a, b) -> {
            LocalDate aDate = LocalDate.parse(a.get(0), dateFormat);
            LocalDate bDate = LocalDate.parse(b.get(0), dateFormat);
            if (aDate.isAfter(bDate)) return -1;
            if (aDate.isBefore(bDate)) return 1;
            return 0;
        };
        data.sort(dateComparator);
        System.out.println("Date Comparator : ");
        data.stream().forEach(System.out::println);
    }


    static void findDuplicateElementsFromArray() {
        Integer[] nums = {1, 2, 3, 4, 3, 1, 9, 7, 9, 4, 0, 10};
        Set<Integer> set = new HashSet<>();
        List<Integer> list = Arrays.stream(nums).filter(i -> !set.add(i)).toList();
        System.out.println("Find Duplicate Elements From Array : ");
        System.out.println("Original : " + Arrays.stream(nums).toList());
        System.out.println("Result : " + list);
    }

    static void findStringsFromListStartsWithDigits() {
        List<String> str = Arrays.asList("1sd", "5as", "kad", "7dvs", "hjf");
        List<String> list = str.stream().filter(s -> Character.isDigit(s.charAt(0))).toList();
        System.out.println("Find Strings From List Starts With Digits : ");
        System.out.println("Original : " + str);
        System.out.println("Result : " + list);
    }

    static void reverseEachWordOfString() {
        String str = "Java is good programming. Need to learn to upskill.";
        List<StringBuilder> list = Arrays.stream(str.toLowerCase().replaceAll("[^a-z\\s]", "")
                .split(" ")).map(str1 -> new StringBuilder(str1).reverse()).toList();
        System.out.println("Original : " + list);
        System.out.println("Result : " + list);
    }

    static void findCommonElementsBetween2Arrays() {
        Integer[] list1 = {6, 2, 3, 4, 5, 8};
        Integer[] list2 = {7, 1, 5, 3, 2, 8, 9, 0};
        List<Integer> list = IntStream.concat(Arrays.stream(list1)
                        .mapToInt(i -> (int) i), Arrays.stream(list2).mapToInt(i -> (int) i)).sorted().boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(e -> e.getValue() > 1).map(Map.Entry::getKey).toList();
        System.out.println("Find Common Elements in Lists : ");
        System.out.println("List1 : " + Arrays.stream(list1).toList());
        System.out.println("List2 : " + Arrays.stream(list2).toList());
        System.out.println("Result List : " + list);
    }

    static void findSecondLargestNumFromIntegerArray() {
        Integer[] nums = {12, 34, 23, 6, 76, 54, 78, 19, 27, 17};
        List<Integer> list = Arrays.stream(nums).sorted(Comparator.reverseOrder()).skip(1).limit(1).toList();
        System.out.println("Find Second Largest Number from Integer Array : " + list);
    }

    static void findSumOfAllDigitsOfNumber() {
        int num = 13468;
        int sum = Stream.of(String.valueOf(num).split("")).mapToInt(Integer::valueOf).sum();
        System.out.println(num + " : Sum of all integer in given num : " + sum);
    }

    static void checkIfAnagram() {
        String str1 = "bats";
        String str2 = "stab";
        boolean equals = Arrays.stream(str1.split("")).sorted().collect(Collectors.joining())
                .equals(Arrays.stream(str2.split("")).sorted().collect(Collectors.joining()));
        System.out.println("Is it anagram ? : " + equals);
    }

    static void findMaximumandMinimuminList() {
        List<Integer> nums = Arrays.asList(6, 4, 3, 7, 8, 3, 1, 9, 10, 0, -1, 24);
        Integer min = nums.stream().min(Comparator.naturalOrder()).get();
        Integer max = nums.stream().max(Comparator.naturalOrder()).get();
        System.out.println("Elements In Array : Minimum - " + min);
        System.out.println("Elements In Array : Maximum - " + max);
    }


    static void joinStringsListWithPrefixDelimiterSuffix() {
        System.out.println("Print joined string with Suffix, delimeter, Prefix");
        List<String> words = Arrays.asList("word1", "word2", "word3", "word4");
        String collect = words.stream().collect(Collectors.joining(",", "{", "}"));
        System.out.println(collect);
    }

    static void findFrequencyOfEachElementInArray() {
        System.out.println("Find frequency of Each Element in Array : ");
        int[] nums = {1, 3, 5, 7, 8, 9, 0, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        Map<Integer, Long> collect = Arrays.stream(nums).sorted().boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect);
    }

    static void removeDuplicateElementsFromLit() {
        System.out.println("Remove all duplicate elements from List : ");
        List<Integer> nums = Arrays.asList(1, 4, 5, 6, 7, 8, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0);
        List<Integer> result = nums.stream().distinct().sorted().toList();
        System.out.println(result);
    }

    static void findAgeUingDateUtil() {
        System.out.println("Find age of Person : ");
        LocalDate birthDate = LocalDate.of(1993, 5, 8);
        LocalDate presentDate = LocalDate.now();
        long age = ChronoUnit.YEARS.between(birthDate, presentDate);
        System.out.println(age);
    }

    static void findLastElementOfArray() {
        System.out.println("Find Last Element of an Array : ");
        List<Integer> nums = Arrays.asList(1, 5, 2, 3, 8, 3, 9, 6);
        List<Integer> list = nums.stream().skip(nums.size() - 1).toList();
        System.out.println(list);
    }

    static void checkPalindromeUsingStream() {
        System.out.println("check Palindrome Using Java Stream : ");
        String str = "sanggnas";
        boolean matched = IntStream.range(0, str.length() / 2).noneMatch(i -> str.charAt(i) != str.charAt(str.length() - i - 1));
        System.out.println(matched);
    }

    static void listOfStringWithIncreasingLength() {
        System.out.println("List of String with Increasing Length : ");
        String str = "Java is good language. Student must learn to upskilling";
        List<String> list = Arrays.stream(str.toLowerCase().replaceAll("[^a-z\\s]", " ").split(" "))
                .sorted(Comparator.comparing(String::length)).toList();
        System.out.println(list);
    }

    static void minmax3NumsFromList() {
        System.out.println("Find minimum 3 numbers from List : ");
        List<Integer> nums = Arrays.asList(5, 6, 3, 7, 8, 1, 2, 4, 9, 10, 19, 14, 16, 13, 17, 20);
        List<Integer> minlist = nums.stream().sorted().limit(3).toList();
        List<Integer> maxlist = nums.stream().sorted(Comparator.reverseOrder()).limit(3).toList();
        System.out.println("3 nums Minimum : " + minlist);
        System.out.println("3 nums Maximum : " + maxlist);
    }

    static void merge2UnsortedArrayinOneSortedArray() {
        System.out.println("Merge 2 Unsorted List into Single List : ");
        List<Integer> nums1 = Arrays.asList(5, 3, 7, 8, 4, 2, 1, 9);
        List<Integer> nums2 = Arrays.asList(10, 18, 12, 14, 16, 15);
        List<Integer> sorted = Stream.concat(nums1.stream(), nums2.stream()).sorted().peek(System.out::println).toList();
        System.out.println(sorted);
    }

    static void findMultipleOf5() {
        System.out.println("Find Multiples Of 5 from List : ");
        List<Integer> nums = Arrays.asList(5, 6, 10, 15, 67, 20, 31, 25);
        List<Integer> list = nums.stream().filter(num -> num % 5 == 0).toList();
        System.out.println(list);
    }

    static void sortListinReverseOrder() {
        List<Character> nums = Arrays.asList('a', 'f', 's', 't', 'w', 'y');
        List<Character> list = nums.stream().sorted(Comparator.reverseOrder()).toList();
        System.out.println(list);
    }

    static void findFrequencyOfEachCharacter() {
        System.out.println("Find Frequency of Each Character in String : ");
        String str = "abcacgbdefd";
        Map<Character, Long> collect = str.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect);
    }

    static void seperateOddAndEvenNumbers() {
        System.out.println("Seperate Odd and Even Numbers : ");
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> collect = nums.stream().collect(Collectors.partitioningBy(i -> i % 2 == 0)).entrySet().stream()
                .flatMap(list -> list.getValue().stream()).collect(Collectors.toList());
        System.out.println(collect);
    }

    static void findFirstNonRepeatingCharacter() {
        System.out.println("Find first non repeating character : ");
        String str = "swiss";
        Optional<Map.Entry<Character, Long>> collect = str.chars().mapToObj(c -> (char) c).
                collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(s -> s.getValue() == 1).findFirst();
        System.out.println(collect);
    }

    static void findMaxFrequencyOfFirst2Numbers() {
        System.out.println("Find Max frequency of first 2 numbers : ");

        List<Integer> nums = Arrays.asList(1, 2, 1, 2, 1, 2, 3, 2, 1, 4, 3, 1);
        int k = 2;
        Map<Integer, Long> map = nums.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(map);
        List<Integer> ls = map.entrySet().stream()
                .sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
                .map(Map.Entry::getKey)
                .limit(k).collect(Collectors.toList());
        System.out.println(ls);
    }

    static void frequencyOfWordGroup() {
        System.out.println("Find frequency of 2 combined Words is Groups in given paragraph : ");
        String para = "Ja great. Java is language. Java is OOPS";
        List<String> words = Arrays.stream(para.toLowerCase().replaceAll("[^a-z\\s]", " ").split(" ")).toList();
        System.out.println(words);

        List<String> wordLs = IntStream.range(0, words.size() - 1).
                mapToObj(i -> words.get(i) + " " + words.get(i + 1)).toList();
        System.out.println(wordLs);

        Map<String, Long> map = wordLs.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(map);
    }

    static void fibonacciSeries() {
        System.out.println("Create fibonacci Series using Java Streams : ");
        List<Integer> collect = Stream.iterate(new int[]{0, 1}, f -> new int[]{f[1], f[0] + f[1]}).limit(10)
                .map(f -> f[0]).peek(System.out::println).collect(Collectors.toList());
    }
}
