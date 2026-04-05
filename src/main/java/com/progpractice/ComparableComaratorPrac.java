package com.progpractice;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ComparableComaratorPrac {
    public static void main(String... args){
        Employee[] emps = new Employee[4];

        emps[0] = new Employee(3,"Name3");
        emps[1] = new Employee(1,"Name1");
        emps[2] = new Employee(9,"Name9");
        emps[3] = new Employee(5,"Name5");

        Arrays.sort(emps,new DescOrdering());

        for (Employee emp : emps){
            System.out.println(emp);
        }
        List<Employee> collect = Arrays.stream(emps).sorted().collect(Collectors.toList());
        System.out.println(collect);

    }

    private static class Employee implements Comparable<Employee>{
        private int id;
        private String name;

        public Employee(int id, String name){
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString(){
            return "Employee[ id :" + this.id + " | Name : " + this.name;
        }

        @Override
        public int compareTo(Employee o) {
            return this.id - o.id;
        }
    }

    public static class DescOrdering implements Comparator<Employee>{

        @Override
        public int compare(Employee o1, Employee o2) {
            return o2.id - o1.id;
        }
    }
}
