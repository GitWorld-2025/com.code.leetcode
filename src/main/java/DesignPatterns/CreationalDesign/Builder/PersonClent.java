package DesignPatterns.CreationalDesign.Builder;

public class PersonClent {
  public static void main(String... args){
      PersonBuilder pb1 = new PersonBuilder(1);
      PersonBuilder pb2 = new PersonBuilder(2);

      Person p1 = pb1.buildAge(10).buildEmail("p1.email.com").buildFirstName("p1").buildLastName("b1").build();
      Person p2 = pb1.buildAge(20).buildEmail("p2.email.com").buildFirstName("p2").buildLastName("b2").build();

      System.out.println(p1);
      System.out.println(p2);
  }
}
