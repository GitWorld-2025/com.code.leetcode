package DesignPatterns.CreationalDesign.Builder;

public class PersonBuilder implements PersonBuilderInterface{
    private Person person;

    PersonBuilder(int id){
        this.person = new Person();
        person.setId(id);
    }

    @Override
    public PersonBuilder buildFirstName(String firstName) {
        person.setFirstName(firstName);
        return this;
    }

    @Override
    public PersonBuilder buildLastName(String lastName) {
        person.setLastName(lastName);
        return this;
    }

    @Override
    public PersonBuilder buildAge(int age) {
        person.setAge(age);
        return this;
    }

    @Override
    public PersonBuilder buildEmail(String email) {
        person.setEmail(email);
        return this;
    }

    @Override
    public Person build(){
        return person;
    }
}
