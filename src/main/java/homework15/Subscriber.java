package homework15;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class Subscriber implements Comparable<Subscriber> {

    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private String phoneNumber;

    @Override
    public String toString() {
        return "Subscriber{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subscriber that = (Subscriber) o;
        return age == that.age &&
                Objects.equals(id, that.id) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(phoneNumber, that.phoneNumber);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, firstName, lastName, age, phoneNumber);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Subscriber withId (Long id) {
        this.id = id;
        return this;
    }

    public Subscriber withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }
    public Subscriber withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Subscriber withAge(int age) {
        this.age = age;
        return this;
    }

    public Subscriber withPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    @Override
    public int compareTo(Subscriber o) {
        return this.getId().compareTo(o.getId());
    }


    public static Subscriber[] generateSubscribers(int numberOfSubscribers) {
        Subscriber[] newSubscribers = new Subscriber[numberOfSubscribers +1];
        Data rawData = new Data();

        for (Integer i = 0; i <newSubscribers.length; i++) {
            Subscriber subscriber = new Subscriber();
            newSubscribers[i]= subscriber.withId(i.longValue()+1);
            newSubscribers[i]= subscriber.withFirstName(rawData.generateFirstName());
            newSubscribers[i]= subscriber.withLastName(rawData.generateLastName());
            newSubscribers[i] = subscriber.withAge(rawData.generateAge());
            newSubscribers[i] = subscriber.withPhoneNumber(rawData.generatePhoneNumber());
        }
        return newSubscribers;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(generateSubscribers(2)));



    }
}
