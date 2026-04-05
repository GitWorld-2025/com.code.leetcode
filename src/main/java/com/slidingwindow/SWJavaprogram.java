package com.slidingwindow;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SWJavaprogram {
    public static void main(String... args){
        int lhs = findLHS(new int[]{1, 3, 2, 2, 5, 2, 3, 7});
        System.out.println(lhs);
    }
    public static int findLHS(int[] nums) {
        AtomicInteger maxLen = new AtomicInteger();
        Map<Integer, Long> collect = Arrays.stream(nums).mapToObj(Integer::valueOf)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect);
        collect.entrySet().stream().map(entry->{
            int key = entry.getKey();
            if(collect.containsKey(key+1)){
                long len = entry.getValue() + collect.get(key+1);
                maxLen.set(Math.max(maxLen.get(), (int) len));
            }
            return null;

        });
        return maxLen.get();
    }
    static void slidingWindowMaxSumoFk(){
        int[] arr = {1, 4, 2, 10, 23, 3, 1, 0, 20};
        int k = 4;
        int n = arr.length;
        int maxSum = 0;
        for(int i = 0; i < k; i++) {
            maxSum += arr[i];
        }
        int windowSum = maxSum;
        for(int j = k; j< n-k;j++){
            windowSum = windowSum + arr[j] - arr[j - k];
            maxSum = Math.max(maxSum,windowSum);
        }
        System.out.println("Maximum sum of "+ k + " consecutive elements is: " + maxSum);
    }
}
