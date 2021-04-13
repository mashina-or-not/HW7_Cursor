package Task3;

public class PeopleTask3 {

    private final String firstName;
    private final String lastName;

    public PeopleTask3(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName = " + firstName +
                ", lastName = " + lastName + "}";
    }
}