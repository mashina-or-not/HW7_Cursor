package Task2;

import Task1.Gender;

public class PeopleTask2 {
    private final String name;
    private final int age;
    private final Gender gender;
    private final Country country;

    public PeopleTask2(String name, int age, Gender gender, Country country) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public Country getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return getName() + "(" + getAge() + ")";
    }
}
