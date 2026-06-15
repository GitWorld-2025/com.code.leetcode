package com.CompanyQuestions;

public class CustomParser {
    public static void main(String... args) {
        System.out.println(parseInt("4554675546754675"));
    }

    static int parseInt(String str) throws NumberFormatException {
        int result = 0;
        int index = 0;
        int sign = 1;

        if (str == null || str.isEmpty()) {
            throw new NumberFormatException("Empty String Provided");
        }

        if (str.charAt(0) == '-') {
            sign = -1;
            index++;
        }

        while (index < str.length()) {
            char ch = str.charAt(index);

            if (ch > '9' || ch < '0') {
                throw new NumberFormatException("Invalid String Provided");
            }

            int digit = ch - '0';

            if (result > (Integer.MAX_VALUE - digit) / 10) {
                throw new NumberFormatException("Integer Overflow");
            }
            result = result*10+digit;
            index++;
        }

        return result * sign;
    }
}
