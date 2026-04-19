package com.TopicSolutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class BinarySearch {
    public static void main(String... args) {
        //System.out.println("Binary Search : " + BinarySearchSimple());
        //SearchIn2DArray();
        //KOKOEatingBananas();
        //FindMinimuminRotatedSortedArray();
        SearchinRotatedSortedArray();
        //TimeBasedKey_ValueStoreHashMap
    }

    class TimeBasedKey_ValueStoreHashMap {
        private Map<String, TreeMap> map;

        public TimeBasedKey_ValueStoreHashMap() {
            map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            map.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);
        }

        public String get(String key, int timestamp) {
            if (!map.containsKey(key)) return "";
            TreeMap<Integer, String> timeStamps = map.get(key);
            Map.Entry<Integer, String> entry = timeStamps.floorEntry(timestamp);
            return entry == null ? "" : entry.getValue();
        }
    }

    static void SearchinRotatedSortedArray() {
        int nums[] = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        boolean flag = false;
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                flag = true;
                break;
            }
            if (nums[low] <= nums[mid]) {
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        System.out.println("Search in Rotated Sorted Array : " + flag);
    }

    static void FindMinimuminRotatedSortedArray() {
        int[] nums = {3, 4, 5, 6, 1, 2};

        int low = 0, high = nums.length - 1;
        int min = Integer.MAX_VALUE;
        while (low <= high) {
            if (nums[low] < nums[high]) {
                min = Math.min(min, nums[low]);
                break;
            }
            int mid = (low + high) / 2;
            min = Math.min(min, nums[mid]);
            if (nums[mid] >= nums[low]) low = mid + 1;
            else high = mid - 1;
        }
        System.out.println("Minimum in Rotated Sorted Array : " + min);
    }

    static void KOKOEatingBananas() {
        int[] piles = {30, 11, 23, 4, 20};
        int h = 5;
        int high = Arrays.stream(piles).max().orElse(1);
        int low = 1;
        int k = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            int hCount = 0;
            for (int bananas : piles) {
                hCount += (int) Math.ceil((double) bananas / mid);
            }
            if (h < hCount) low = mid + 1;
            else if (h > hCount) high = mid - 1;
            else {
                k = mid;
                break;
            }
        }

        System.out.println("KoKo Eating Bananas : " + k);
        /// LeetCode Solution
        /*static int minEatingSpeedOptimal(int[] piles ,int h) {
            int mx = Arrays.stream(piles).max().getAsInt();
            int low = 1;int high = mx;

            while(low<high) {
                int mid = (low +high)/2;
                if(check(piles,mid,h)) {
                    high = mid;
                }
                else {
                    low = mid+1;
                }
            }
            return low;
        }

        static boolean check(int[] piles, int mid, int h) {
            int time =0;
            for(int num : piles) {
                time += num/mid;
                if(num%mid !=0)
                    time++;
            }
            return time<=h;

        }*/
    }

    static void SearchIn2DArray() {
        int[][] nums = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int target = 61;
        boolean flag = false;
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (target > nums[mid][nums[mid].length - 1]) low = mid + 1;
            else if (target < nums[mid][0]) high = mid - 1;
            else {
                flag = BinarySearchMethod(nums[mid], target) != -1;
                break;
            }
        }
        System.out.println("Number found : " + flag);
    }

    static int BinarySearchSimple() {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 9;
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] > target) high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }

    static int BinarySearchMethod(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] > target) high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }
}
