package Task1;

public class PeopleTask1 {

    private final String name;
    private final int age;
    private final Gender gender;

    public PeopleTask1(String name, int age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
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

}
