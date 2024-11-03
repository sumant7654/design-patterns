package dev.sumantakumar.designpatterns.creational;

public class BuilderDesignPatternTest {
    public static void main(String[] args) {
        User user0 = new User.Builder("Sumant", "Kumar")
                .age(30)
                .address("Bhubaneswar")
                .gender("Male")
                .phone("+91 9900000000")
                .build();

        User user1 = new User.Builder("Sumair", "Sumair")
                .build();

        User user2 = new User.Builder("Shadab", "Ali")
                .age(26)
                .address("Ranchi")
                .build();

        User user3 = new User.Builder("Swastik", "Panda")
                .address("Bhubaneswar")
                .gender("Male")
                .build();

        System.out.println(user0);
        System.out.println(user1);
        System.out.println(user2);
        System.out.println(user3);

    }
}



class User{

    private final String firstName;
    private final String lastName;
    private final int age;
    private final String gender;
    private final String address;
    private final String phone;

    private User(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.gender = builder.gender;
         this.address = builder.address;
         this.phone = builder.phone;
    }


    static class Builder{
       private final String firstName;
       private final String lastName;
       private int age;
       private String gender;
       private String address;
       private String phone;
       public Builder(String firstName, String lastName) {
           this.firstName = firstName;
           this.lastName = lastName;
       }

       public Builder age(int age) {
           this.age = age;
           return this;
       }
       public Builder gender(String gender) {
           this.gender = gender;
           return this;
       }
       public Builder address(String address) {
           this.address = address;
           return this;
       }
       public Builder phone(String phone) {
           this.phone = phone;
           return this;
       }
       public User build(){
           return new User(this);
       }
    }

    @Override
    public String toString() {
        return "User{" + "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
