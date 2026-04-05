package DesignPatterns.CreationalDesign.Builder;

public interface PersonBuilderInterface {
    PersonBuilder buildFirstName(String firstName);
    PersonBuilder buildLastName(String lastName);
    PersonBuilder buildAge(int age);
    PersonBuilder buildEmail(String email);
    Person build();
}
