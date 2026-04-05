package com.TopicSolutions;

import java.util.*;
import java.util.stream.Collectors;

public class Intervals {
    public static void main(String... args) {
        //MeetingRooms();
        //InsertIntervals();
        //MergeIntervals();
        Non_overlappingIntervals();
    }

    static void Non_overlappingIntervals() {
        int[][] intervals = {{0,1}, {3,4}, {1, 2}};
        //{{1, 100},{1, 11}, {2, 12},{11, 22}};
        List<int[]> list = Arrays.asList(intervals);
        list.sort(Comparator.comparingInt(a -> a[0]));
        Comparator<int[]> compare = (a,b) -> (a[1]- a[0]) - (b[1]-b[0]);
        list.sort(compare);
        list.forEach(i -> System.out.println("I0 : " + i[0] + " || I1 : " + i[1]));


        int operations = 0;
        List<int[]> res = new ArrayList<>();
        res.add(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            int[] last = res.get(res.size() - 1);
            int[] curr = list.get(i);
            if(last[1] > curr[0]) {
                operations++;
            }else res.add(curr);
        }
        System.out.println("No. of Operations : " + operations);
        //res.forEach(i -> System.out.println("I0 : " + i[0] + " || I1 : " + i[1]));
    }

    static void MergeIntervals() {
        int[][] intervals = {{1, 2}, {2, 3}};
        List<int[]> list = Arrays.asList(intervals);
        list.sort(Comparator.comparingInt(i -> i[0]));

        List<int[]> res = new ArrayList<>();
        res.add(list.get(0));

        for (int i = 1; i < list.size(); i++) {
            int[] last = res.get(res.size() - 1);
            int[] curr = list.get(i);
            if (last[1] >= curr[0]) {
                last[1] = Math.max(last[1], curr[1]);
            } else res.add(curr);
        }
        res.forEach(i -> System.out.println("I0 : " + i[0] + " || I1 : " + i[1]));
        //res.stream().toArray(int[][]::new);
    }

    public static void InsertIntervals() {
        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = {4, 8};

        List<int[]> list = new ArrayList<int[]>(Arrays.asList(intervals));
        list.add(newInterval);
        list.sort(Comparator.comparingInt(a -> a[0]));
        List<int[]> res = new ArrayList<>();
        res.add(list.get(0));

        for (int i = 0; i < list.size(); i++) {
            int[] last = res.get(res.size() - 1);
            int[] curr = list.get(i);
            if (last[1] > curr[0]) {
                last[1] = Math.max(last[1], curr[1]);
            } else {
                res.add(curr);
            }
        }

        res.forEach(i -> System.out.println("I0 : " + i[0] + " || I1 : " + i[1]));

    }

    static void MeetingRooms() {
        List<Interval> intervals = Arrays.asList(new Interval(5, 8), new Interval(8, 15));
        intervals.sort(Comparator.comparingInt(a -> a.start));
        boolean flag = true;
        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).start < intervals.get(i - 1).end) flag = false;
        }
        System.out.println("Meeting Rooms : " + flag);
    }

    public static class Interval {
        public int start, end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
