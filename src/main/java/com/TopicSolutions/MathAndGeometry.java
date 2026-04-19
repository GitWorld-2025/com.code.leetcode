package com.TopicSolutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class MathAndGeometry {
    public static void main(String... args) {
        //RotateImage();
        //HappuNumberorNonCyclicNumber();
        //findPlusOne();
        //SpiralMatrix();
        //SetMatrixZeroes();
        //Pow_Of_x_n();
        //MultiplyStrings();
        DayoftheWeek();
        PerfectSquaresLegendresTheorem(13);
    }

    static int PerfectSquaresLegendresTheorem(int n) {

        int sqrtN = (int) Math.sqrt(n);
        if (sqrtN * sqrtN == n) return 1;

        for (int i = 1; i * i < n; i++) {
            int square = i * i;
            int base = (int) Math.sqrt(n - square);
            if (base * base == n - square) return 2;
        }

        while (n % 4 == 0) n /= 4;

        if(n % 8 != 7)  return 3;
        return 4;
    }

    static void DayoftheWeek() {
        /// PENDING
        int day = 31, month = 8, year = 2016;

        List<String> days = Arrays.asList("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday");
        List<Integer> mDays = Arrays.asList(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);


        int totalDays = 0;
        for (int y = 1971; y < year; y++) {
            totalDays += isLeapYear(y) ? 366 : 365;
        }

        for (int m = 1; m < month; m++) {
            if (m == 2 || isLeapYear(year)) {
                totalDays += 29;
            } else {
                totalDays += mDays.get(m - 1);
            }
        }

        totalDays += day;
        String d = days.get((totalDays + 3) % 7);
        System.out.println(d);
    }

    static boolean isLeapYear(int year) {
        return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
    }

    static void MultiplyStrings() {
        String num1 = "123", num2 = "456";

        char[] res = new char[num1.length() * 2];
        Arrays.fill(res, '0');
        for (int i = num2.length() - 1; i >= 0; i--) {
            int carry = 0;
            int k = res.length - 1 - i;
            for (int j = num1.length() - 1; j >= 0; j--) {
                int sum = (num1.charAt(j) - '0') * (num2.charAt(i) - '0');
                res[k] = (char) (((int) res[k] + sum + carry) % 10);
                carry = ((int) res[k] + sum + carry) / 10;
                k--;
            }
        }
        for (char c : res) System.out.print(c);
    }

    static void Pow_Of_x_n() {
        double x = 2.00000;
        int n = -2;
        //if (x == 0) return 0;
        //if (n == 0) return 1;

        double res = 1;
        long power = Math.abs((long) n);

        while (power > 0) {
            if ((power & 1) == 1) {
                res *= x;
            }
            x *= x;
            power >>= 1;
        }
        double result = n >= 0 ? res : 1 / res;
        System.out.println("Pow_Of_x_n : " + result);
    }

    static void SetMatrixZeroes() {
        //int[][] matrix = {{1, 2, 3}, {4, 0, 5}, {6, 7, 8}};
        int[][] matrix = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};

        for (int[] num : matrix) System.out.println("|" + num[0] + "|" + num[1] + "|" + num[2] + "|" + num[3] + "|");
        System.out.println("-----------------------");

        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        //Arrays.fill(visited,false);
        int top = 0, bottom = matrix.length;
        int left = 0, right = matrix[0].length;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (visited[i][j]) continue;
                if (matrix[i][j] == 0) {
                    visited[i][j] = true;
                    /// set Matrix zero;
                    for (int t = top, l = left; t < bottom || l < right; t++, l++) {
                        if (t < bottom) {
                            if (matrix[t][j] != 0) {
                                matrix[t][j] = 0;
                                visited[t][j] = true;
                            }
                        }
                        if (l < right) {
                            if (matrix[i][l] != 0) {
                                matrix[i][l] = 0;
                                visited[i][l] = true;
                            }
                        }
                    }
                } else visited[i][j] = true;
                ;
            }
        }
        for (int[] num : matrix) System.out.println("|" + num[0] + "|" + num[1] + "|" + num[2] + "|" + num[3] + "|");
    }

    static void SpiralMatrix() {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};

        List<Integer> result = new ArrayList<>();
        int left = 0, right = matrix[0].length;
        int top = 0, bottom = matrix.length;

        while (left < right && top < bottom) {
            for (int i = left; i < right; i++) {
                result.add(matrix[top][i]);
            }
            top++;
            for (int i = top; i < bottom; i++) {
                result.add(matrix[i][right - 1]);
            }
            right--;
            if (!(left < right && top < bottom)) {
                break;
            }
            for (int i = right - 1; i >= left; i--) {
                result.add(matrix[bottom - 1][i]);
            }
            bottom--;
            for (int i = bottom - 1; i >= top; i--) {
                result.add(matrix[i][left]);
            }
            left++;
        }
        System.out.println(result);
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

    static boolean HappuNumberorNonCyclicNumber() {
        int n = 19;
        int slow, fast;
        slow = fast = n;
        boolean flag = true;
        while (true) {

            slow = numSquare(slow);
            fast = numSquare(numSquare(fast));
            if (slow == 1) return true;
            if (slow == fast) return false;
        }
    }

    static int numSquare(int n) {
        int sum = 0;
        while (n > 0) {
            sum += (n % 10) * (n % 10);
            n = n / 10;
        }
        return sum;
    }

    static void RotateImage() {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        int l = 0;
        int r = matrix.length - 1;

        while (l < r) {
            for (int i = 0; i < r - l; i++) {
                int top = l;
                int bottom = r;

                int topLeft = matrix[top][l + i];
                matrix[top][l + i] = matrix[bottom - i][l];
                matrix[bottom - i][l] = matrix[bottom][r - i];
                matrix[bottom][r - i] = matrix[top + i][r];
                matrix[top + i][r] = topLeft;
            }
            l++;
            r--;
        }

        for (int[] num : matrix) System.out.println("|" + num[0] + "|" + num[1] + "|" + num[2] + "|");

    }
}
