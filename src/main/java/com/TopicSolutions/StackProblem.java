package com.TopicSolutions;

import java.util.*;

public class StackProblem {
    public static void main(String... args) {
        //validParanthesisCaller();
        //minStackCaller();
        //EvaluateReversePolishNotation();
        DailyTemperatures();
        //Pattern132();
        //FreqStackCaller();
        //StockSpannerCaller();
    }

    static void StockSpannerCaller() {
        StockSpanner stockSpanner = new StockSpanner();
        System.out.println();
        System.out.println("return 1 : " + stockSpanner.next(100)); // return 1
        System.out.println("return 1 : " + stockSpanner.next(80));  // return 1
        System.out.println("return 1 : " + stockSpanner.next(60));  // return 1
        System.out.println("return 2 : " + stockSpanner.next(70));  // return 2
        System.out.println("return 1 : " + stockSpanner.next(60));  // return 1
        System.out.println("return 4 : " + stockSpanner.next(75));  // return 4, because the last 4 prices (including today's price of 75) were less than or equal to today's price.
        System.out.println("return 6 : " + stockSpanner.next(85));  // return 6
    }

    static class StockSpanner {
        Stack<int[]> st;
        int idx;
        public StockSpanner() {
            st = new Stack<>();
            idx = -1;
        }

        public int next(int price) {
            idx += 1;

            while(!st.isEmpty() && st.peek()[0] <= price) {
                st.pop();
            }

            int ans = idx - (st.isEmpty() ? -1 : st.peek()[1]);
            st.push(new int[] {price, idx});

            return ans;
        }
    }

    static void FreqStackCaller() {
        FreqStack freqStack = new FreqStack();
        freqStack.push(5); // The stack is [5]
        freqStack.push(7); // The stack is [5,7]
        freqStack.push(5); // The stack is [5,7,5]
        freqStack.push(7); // The stack is [5,7,5,7]
        freqStack.push(4); // The stack is [5,7,5,7,4]
        freqStack.push(5); // The stack is [5,7,5,7,4,5]
        System.out.println(freqStack.pop());  // return 5, as 5 is the most frequent. The stack becomes [5,7,5,7,4].
        System.out.println(freqStack.pop());    // return 7, as 5 and 7 is the most frequent, but 7 is closest to the top. The stack becomes [5,7,5,4].
        System.out.println(freqStack.pop());    // return 5, as 5 is the most frequent. The stack becomes [5,7,4].
        System.out.println(freqStack.pop());
    }

    static class FreqStack {
        Map<Integer, Stack<Integer>> stackMap;
        Map<Integer, Integer> freqMap;

        public FreqStack() {
            stackMap = new HashMap<>();
            freqMap = new TreeMap<>();
        }

        public void push(int val) {
            freqMap.put(val, freqMap.getOrDefault(val, 0) + 1);
            Stack<Integer> st = stackMap.getOrDefault(freqMap.get(val), new Stack<>());
            st.push(val);
            stackMap.put(freqMap.get(val), st);
        }

        public int pop() {
            Map.Entry<Integer, Integer> maxFreqElement = freqMap.entrySet().stream().max((a, b) -> a.getValue() - b.getValue()).orElseGet(null);
            int maxFreq = maxFreqElement.getValue();
            Stack<Integer> st = stackMap.get(maxFreq);
            int poped = st.pop();
            if (st.isEmpty()) stackMap.remove(maxFreq);
            if (maxFreq == 1) {
                freqMap.remove(poped);
            } else {
                freqMap.put(poped, freqMap.get(poped) - 1);
            }
            return poped;
        }
    }

    static void Pattern132() {
        int[] nums = {6, 12, 2, 3, 4, 11, 13};
        boolean flag = false;
        int c = Integer.MIN_VALUE;
        Stack<Integer> st = new Stack<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < c) {
                flag = true;
            }
            while (!st.empty() && st.peek() < nums[i]) {
                c = st.pop();
            }
            st.push(nums[i]);
        }
        System.out.println("Pattern123 EXITS : " + flag);
    }

    static void DailyTemperatures() {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        Stack<Integer> st = new Stack<>();
        int[] result = new int[temperatures.length];

        for(int i = 0;  i < temperatures.length; i++){

            while(!st.isEmpty() && temperatures[st.peek()]<temperatures[i]){
                int j = st.pop();
                result[j] = i - j;
            }
            st.push(i);
        }
        for(int num : result) System.out.println(num);
    }

    static void EvaluateReversePolishNotation() {
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        int result = Integer.valueOf(tokens[0]);
        Stack<Integer> stack = new Stack<>();
        List<String> syntax = Arrays.asList("+", "-", "*", "/");
        for (int i = 0; i < tokens.length; i++) {
            String st = tokens[i];
            if (syntax.contains(st)) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                switch (st) {
                    case "+":
                        result = num1 + num2;
                        stack.push(result);
                        break;
                    case "-":
                        result = num1 - num2;
                        stack.push(result);
                        break;
                    case "*":
                        result = num1 * num2;
                        stack.push(result);
                        break;
                    case "/":
                        result = num1 / num2;
                        stack.push(result);
                        break;
                }
            } else stack.push(Integer.valueOf(tokens[i]));
        }

        System.out.println("Result : " + result);
    }

    static void minStackCaller() {
        StackProblem.MinStack stack = new MinStack();
        stack.push(3);
        stack.push(2);
        stack.push(1);
        stack.display();
        System.out.println("TOP : " + stack.top());
        System.out.println("GETMIN : " + stack.getMin());
        stack.pop();
        stack.display();
        System.out.println("GETMIN : " + stack.getMin());
    }

    static class MinStack {
        int[] arr;
        int min;
        int index;

        public MinStack() {
            this.arr = new int[5];
            this.index = -1;
            this.min = Integer.MAX_VALUE;
            Arrays.fill(this.arr, -1);
        }

        public void push(int val) {
            this.min = Math.min(val, this.min);
            this.arr[++this.index] = val;
        }

        public void pop() {
            this.arr[this.index--] = -1;
            this.min = Integer.MAX_VALUE;
            for (int i = 0; i < this.arr.length; i++) {
                if (this.arr[i] != -1) {
                    this.min = Math.min(this.min, this.arr[i]);
                }
            }
        }

        public int top() {
            return this.arr[0];
        }

        public int getMin() {
            return this.min;
        }

        public void display() {
            System.out.println("----------------");
            for (int num : arr) System.out.print(num + "|");
            System.out.println("----------------");
        }
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
}