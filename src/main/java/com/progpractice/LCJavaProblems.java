package com.progpractice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LCJavaProblems {
    public static void main(String... args) {


    }

    static void findMedianSortedArrays(){
        int[] nums1 = {1,3};
        int[] nums2 = {2};

        int n1 = nums1.length;
        int n2 = nums2.length;

        List<Integer> merged = IntStream.concat(Arrays.stream(nums1), Arrays.stream(nums2))
                .sorted()
                .boxed()
                .collect(Collectors.toList());

        double median;
        int totalLength = n1 + n2;
        if(totalLength % 2 == 0){
            median = (merged.get(totalLength/2 - 1) + merged.get(totalLength/2)) / 2.0;
        } else {
            median = merged.get(totalLength/2);
        }

        System.out.println("Median is: " + median);
    }
}
