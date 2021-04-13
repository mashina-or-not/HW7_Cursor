import Task1.Gender;
import Task1.PeopleTask1;
import Task2.Continent;
import Task2.Country;
import Task2.PeopleTask2;
import Task3.PeopleCollector;
import Task3.PeopleTask3;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static Task1.Gender.FEMALE;
import static Task1.Gender.MALE;
import static Task2.Country.*;

public class Main {
    public static void main(String[] args) {
        //Task1
        List<PeopleTask1> people = new ArrayList<>(List.of(
                new PeopleTask1("Ivan", 11, MALE),
                new PeopleTask1("Ihor", 19, MALE),
                new PeopleTask1("Lada", 23, FEMALE),
                new PeopleTask1("Nina", 70, FEMALE),
                new PeopleTask1("Luna", 28, FEMALE),
                new PeopleTask1("Vlad", 21, MALE)
        ));

        Set<String> sortPeople = people.stream()
                .filter(human -> human.getAge() >= 18 && human.getAge() < 60)
                .collect(HashSet::new, (k, v) -> k.add(v.getName() + ":" + (v.getGender() == MALE ? "male" : "female")), HashSet::addAll);
        sortPeople.forEach(System.out::println);
        System.out.println("-".repeat(100));

        //Task2
        List<PeopleTask2> peopleInternationale = new ArrayList<>(List.of(
                new PeopleTask2("Ivan", 11, MALE, USA),
                new PeopleTask2("Ihor", 19, MALE, NIGER),
                new PeopleTask2("Lada", 23, FEMALE, CHILE),
                new PeopleTask2("Nina", 70, FEMALE, CHINA),
                new PeopleTask2("Luna", 88, FEMALE, AUSTRALIA),
                new PeopleTask2("Vlad", 21, MALE, UKRAINE),
                new PeopleTask2("Bob\uD83E\uDD66", 30, MALE, NEDERLAND)
        ));

        Map<Continent, Map<Country, Map<Gender, List<PeopleTask2>>>> treePeople = peopleInternationale.stream()
                .filter(human -> human.getAge() >= 18 && human.getAge() < 60)
                .collect(Collectors.groupingBy(k -> k.getCountry().getContinent(),
                        Collectors.groupingBy(PeopleTask2::getCountry,
                                Collectors.groupingBy(PeopleTask2::getGender))));

        treePeople.forEach((continent, countryMap) -> {
            System.out.println(continent);
            countryMap.forEach(((country, genderMap) -> {
                System.out.println("\t" + country);
                genderMap.forEach(((gender, task2) -> {
                    System.out.println("\t\t" + gender);
                    task2.forEach(k -> System.out.println("\t\t\t" + k));
                }));
            }));
        });
        System.out.println("-".repeat(100));

        //Task3
        List<PeopleTask3> fullName = Stream.of("John", "Smith", "John", "Doe", "Jane", "Doe")
                .collect(PeopleCollector.getInstance());
        fullName.forEach(System.out::println);
    }
}