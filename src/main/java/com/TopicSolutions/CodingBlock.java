package com.TopicSolutions;

import java.math.BigInteger;
import java.util.*;

public class CodingBlock {
    public static void main(String... args) {
        //findMissingNumbers();
        //removeKDigitsToMakeSmallestNumber();
        //findSqrtBinarySearch();
        //findTrailingZerosinFactorial();
        //Non_OverlappingIntervals();
        //CountWaysToMatrixEnd();
        //System.out.println("Fast Power : " + fastPower(10, 2));
        //LemonadeChange();
        //distributeCandies();
        //gcdOfStrings();
        //InsertAtEndOfStackUsingRecursion();
        //findNthDigit();
        countPrimesSeive();
    }

    static void countPrimesSeive() {
        int n = 3;
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        if (n >= 0) isPrime[0] = false;
        if (n >= 1) isPrime[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if(isPrime[i]){
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) result.add(i);
        }
        System.out.println(result);
        System.out.println("Number of primes : " + result.size());
    }

    static void findNthDigit() {
        int n = 11;
        long digitlength = 1;
        int start = 1;
        int end = 9;

        // digitlength*end = digits between the particular range
        // 1-9 , 10-99 , 100-999
        while (n > digitlength * end) {
            n -= digitlength * end;
            digitlength++;
            start *= 10;
            end *= 10;
        }

        start += (n - 1) / digitlength;
        String number = String.valueOf(start); // Exact number

        int index = (int) ((n - 1) % digitlength); // Exact digit
        //return number.charAt(index) - '0';
        System.out.println(number.charAt(index) - '0');
    }

    static void InsertAtEndOfStackUsingRecursion() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        StackRecursion(stack);
        Iterator<Integer> itr = stack.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }

    static void StackRecursion(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            stack.push(4);
            return;
        }
        int temp = stack.pop();
        StackRecursion(stack);
        stack.push(temp);
    }

    static void gcdOfStrings() {
        String str1 = "ABCABC", str2 = "ABC";
        if (!(str1 + str2).equalsIgnoreCase(str2 + str1)) {
        }
        int m = str1.length(), n = str2.length();
        /// One solution to find GCD int res = BigInteger.valueOf(m).gcd(BigInteger.valueOf(n)).intValue();
        int res = findGCD(m, n);


        System.out.println(str2.substring(0, res));
    }

    public static int findGCD(int a, int b) {
        /// Euclid Algorithm to find GCD
        if (b == 0) {
            return a;
        }
        return findGCD(b, a % b);
    }

    static void distributeCandies() {
        int[] candyType = {6, 6, 6, 6};
        int result = 0;
        int candy = candyType.length / 2;
        Set<Integer> set = new HashSet<>();
        for (int n : candyType) {
            set.add(n);
        }
        result = Math.min(candy, set.size());
        System.out.println("Distribute Candies : " + result);
    }

    static void LemonadeChange() {
        int[] customers = {5, 5, 10, 10, 20};
        int count5 = 0, count10 = 0, count20 = 0;
        boolean flag = true;

        for (int transaction : customers) {
            if (transaction == 5) {
                count5++;
            } else if (transaction == 10) {
                count10++;
                count5--;
            } else {
                count20++;
                count10--;
                if (count10 < 0) {
                    count5 = count5 - 3;
                    count10 = 0;
                } else {
                    count5--;
                }
            }
            if (count5 < 0) {
                flag = false;
                break;
            }
        }

        System.out.println(flag);
    }

    static int fastPower(int power, int num) {
        /// Find 2 to the power 10 eg. num to the power
        if (power == 0) return 1;
        int ans = fastPower(power / 2, num);
        if (power % 2 == 0) {
            return ans * ans;
        } else {
            return ans * ans * num;
        }
    }

    static void CountWaysToMatrixEnd() {
        int m = 4;
        int n = 4;

        int[][] matrix = new int[m][n];
        for (int[] row : matrix) Arrays.fill(row, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                matrix[i][j] = matrix[i][j - 1] + matrix[i - 1][j];
            }
        }

        System.out.println("Count Ways to reach Matrix End : " + matrix[m - 1][n - 1]);
    }

    static void Non_OverlappingIntervals() {
        /// Intervals
        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        Comparator<int[]> compare = (int[] a, int[] b) -> (b[1] - a[1]);
        //Arrays.sort(intervals,compare);
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            if (result.get(result.size() - 1)[1] <= intervals[i][0]) {
                result.add(intervals[i]);
            }
        }
        for (int[] i : result) {
            System.out.println("{ " + i[0] + " , " + i[1] + " }");
        }
    }

    static void findTrailingZerosinFactorial() {
        /// Arrays and Hashing
        /// Find trailing zeros in factorial eg. 10! = 3628800
        /// Solution approach find no. of factors 5's in all nos
        int count = 0;
        for (int i = 1; i <= 10; i++) {
            if (i % 5 == 0) count++;
        }
        System.out.println("Find trailing zeros in factorial : " + count);
    }

    static void findSqrtBinarySearch() {
        int n = 24;
        int precision = 2;

        int start = 0;
        int end = n;
        double ans = 0;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid * mid == n) {
                ans = mid;
                break;
            }
            if (mid * mid < n) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        double factor = 0.1;
        for (int i = 0; i < precision; i++) {
            while ((ans + factor) * (ans + factor) <= n) {
                ans += factor;
            }
            factor /= 10;
        }

        System.out.println("Square Root Using Binary Search : " + ans);
    }

    static void findMissingNumbers() {
        ///  Arrays and Hashing
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = -(nums[index]);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) System.out.println("Missing Number : " + (i + 1));
        }
    }

    static void removeKDigitsToMakeSmallestNumber() {
        /// Stack
        int[] num = {1, 4, 3, 2, 2, 1, 9}; // Smallest number is 1219
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < num.length; i++) {
            if (!stack.isEmpty()) {
                int prev = stack.peek();
                if (prev > num[i]) stack.pop();
            }
            stack.push(num[i]);
        }
        Iterator<Integer> itr = stack.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}
