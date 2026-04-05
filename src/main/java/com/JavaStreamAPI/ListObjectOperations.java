package com.JavaStreamAPI;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class ListObjectOperations {
    public static void main(String... args) {
        List<Product> productList = generateProductList();
        //problemsOnAlphabetics(productList);
        findPricesOfInventorytory(productList);
    }

    public static void problemsOnAlphabetics(List<Product> productList) {
        //Sort all product in with owner name
        List<String> alphabetic_order = productList.stream().sorted(Comparator.comparing(Product::getOwner))
                .peek(System.out::println)
                .map(product -> product.getOwner()).toList();

        System.out.println(alphabetic_order);
        //collect all Listing seperate owners with List products
        TreeMap<String, List<String>> collect = productList.stream()
                .collect(Collectors.groupingBy(Product::getOwner, TreeMap::new, Collectors.mapping(Product::getProductName, toList())));

        System.out.println("List of Owners with Products ");
        System.out.println(collect);

    }

    public static void findPricesOfInventorytory(List<Product> productList) {
        //find total prices of all products
        Integer totalPrice = productList.stream().map(product -> product.getPrice())
                .reduce(0, (a, b) -> a + b);
        System.out.println("find total prices of all products : " + totalPrice);

        //find total prices of all available products inventory
        Integer totalAvailablePrice = productList.stream().filter(product -> product.isAvailaiblity()).map(product -> product.getPrice() * product.count).reduce(0, (a, b) -> a + b);
        System.out.println("find total prices of all available products inventory : " + totalAvailablePrice);

        //Calculate total amount of inventory for Individual owner
        TreeMap<String, List<Integer>> collect = productList.stream().collect(Collectors.groupingBy(Product::getOwner, TreeMap::new,
                Collectors.mapping(pr -> pr.getPrice() * pr.getCount(), toList())));
        System.out.println("Calculate total amount of inventory for Individual owner per product: ");
        System.out.println(collect);

        //Calculate total amount of inventory for Individual owner total amount
        TreeMap<String, Integer> collect1 = productList.stream().collect(Collectors.groupingBy(Product::getOwner, TreeMap::new,
                Collectors.mapping(pr -> pr.getPrice() * pr.getCount(), Collectors.reducing(0, (a, b) -> a + b))));
        System.out.println("//Calculate total amount of inventory for Individual owner total amount");
        System.out.println(collect1);
    }

    public static List<Product> generateProductList() {
        List<Product> productList = Arrays.asList(
                new Product(100, "John", 50000, "Laptop", true, 2),
                new Product(101, "Mike", 30000, "Desktop", false, 3),
                new Product(102, "John", 2000, "Casio", true, 4),
                new Product(103, "Suj", 4000, "Mobile", false, 1),
                new Product(104, "Ash", 1000, "Zapper", true, 6),
                new Product(105, "Mike", 500, "Mouse", true, 8)
        );
        return productList;
    }

    static class Product {
        public int getProductCD() {
            return productCD;
        }

        public void setProductCD(int productCD) {
            this.productCD = productCD;
        }

        public String getOwner() {
            return owner;
        }

        public void setOwner(String owner) {
            this.owner = owner;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public boolean isAvailaiblity() {
            return availaiblity;
        }

        public void setAvailaiblity(boolean availaiblity) {
            this.availaiblity = availaiblity;
        }

        private int productCD;

        public Product(int productCD, String owner, int price, String productName, boolean availaiblity, int count) {
            this.productCD = productCD;
            this.owner = owner;
            this.price = price;
            this.productName = productName;
            this.availaiblity = availaiblity;
            this.count = count;
        }

        private String owner;
        private int price;
        private String productName;
        private boolean availaiblity;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        private int count;

        @Override
        public String toString() {
            return "Product{" +
                    "productCD=" + productCD +
                    ", owner='" + owner + '\'' +
                    ", price=" + price +
                    ", productName='" + productName + '\'' +
                    ", availaiblity=" + availaiblity +
                    ", count=" + count +
                    '}';
        }
    }
}


