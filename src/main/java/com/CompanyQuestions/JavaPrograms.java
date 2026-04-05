package com.CompanyQuestions;

import java.util.HashMap;
import java.util.Map;

public class JavaPrograms {
    public static void main(String... args) {
        stringSubstitution();
    }



    static void stringSubstitution(){
        String s = "aa";
        String t = "bc";
        int moves = 1;
        StringBuilder sb = new StringBuilder(s);
        while(sb.indexOf("a") > -1) {
            for(int i = 0; i < sb.length(); i++) {
                if(sb.charAt(i) == 'a'){
                    sb.replace(i,i+1,t);
                    moves++;
                }
            }
        }
        System.out.println(moves);
    }
}
