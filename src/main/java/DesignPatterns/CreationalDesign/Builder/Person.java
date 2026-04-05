package DesignPatterns.CreationalDesign.Builder;

public class Person {
    private int id;
    private String FirstName;
    private String LastName;
    private int age;
    private String email;

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public void setLastName(String lastName) {
        this.LastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
