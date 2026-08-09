package com.TopicSolutions;

import java.util.*;
import java.util.stream.Collectors;

public class Heap_PriorityQueue {
    public static void main(String... args) {
        //KthLargestElementinaStreamCaller();
        //LastStoneWeight();
        //TaskScheduler();
        RelativeRanks();
    }

    static void RelativeRanks() {
        int[] score = {10, 3, 8, 9, 4};
        int N = score.length;
        int[] scoreCopy = new int[N];
        System.arraycopy(score, 0, scoreCopy, 0, N);

        // Save the index of each athlete
        Map<Integer, Integer> scoreToIndex = new HashMap<>();
        for (int i = 0; i < N; i++) {
            scoreToIndex.put(scoreCopy[i], i);
        }

        // Sort scoreCopy in ascending order
        Arrays.sort(scoreCopy);

        // Assign ranks to athletes
        // Traverse scoreCopy in reverse
        String[] rank = new String[N];
        for (int i = 0; i < N; i++) {
            if (i == 0) {
                rank[scoreToIndex.get(scoreCopy[N - i - 1])] = "Gold Medal";
            } else if (i == 1) {
                rank[scoreToIndex.get(scoreCopy[N - i - 1])] = "Silver Medal";
            } else if (i == 2) {
                rank[scoreToIndex.get(scoreCopy[N - i - 1])] = "Bronze Medal";
            } else {
                rank[scoreToIndex.get(scoreCopy[N - i - 1])] = Integer.toString(i + 1);
            }
        }

        for(String s : rank) System.out.println(s);
    }

    static void TaskScheduler() {
        char[] tasks = {'X', 'X', 'Y', 'Y', 'Z'};
        int n = 2;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        int[] count = new int[26];
        for (char task : tasks) count[task - 'A']++;
        for (int cnt : count) {
            if (cnt > 0) maxHeap.add(cnt);
        }
        Queue<int[]> q = new LinkedList<>();
        int time = 0;

        while (!maxHeap.isEmpty() || !q.isEmpty()) {
            time++;

            if (maxHeap.isEmpty()) {
                time = q.peek()[1];
            } else {
                int cnt = maxHeap.poll() - 1;
                if (cnt > 0) {
                    q.add(new int[]{cnt, time + n});
                }
            }
            if (!q.isEmpty() && q.peek()[1] == time) {
                maxHeap.add(q.poll()[0]);
            }
        }
        System.out.println(time);
    }

    static void LastStoneWeight() {
        Integer[] stones = {2, 3, 6, 2, 4};
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int stone : stones) heap.add(-stone);

        while (heap.size() > 1) {
            int first = heap.poll();
            int second = heap.poll();
            if (second > first) {
                heap.offer(first - second);
            }
        }
        heap.offer(0);
        System.out.println(Math.abs(heap.peek()));
    }

    static void KthLargestElementinaStreamCaller() {
        Queue<Integer> minHeap = new PriorityQueue<>();
        int[] nums = {1, 2, 3, 3};
        int k = 3;
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) minHeap.poll();
        }
        System.out.println(minHeap);
        add(4, minHeap, k);
        add(5, minHeap, k);
        System.out.println(minHeap);
    }

    static int add(int val, Queue<Integer> minHeap, int k) {
        minHeap.offer(val);
        if (minHeap.size() > k) minHeap.poll();
        return 0;
    }

}
