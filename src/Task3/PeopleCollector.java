package Task3;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class PeopleCollector implements Collector<String, List<String>, List<PeopleTask3>> {
    private PeopleCollector() {
    }

    private List<PeopleTask3> listOfPeople(List<String> list) {
        if (list.size() % 2 != 0)
            throw new IllegalArgumentException("Odd number of lines");
        List<PeopleTask3> listOfPeople = new ArrayList<>();
        for (int i = 0; i < list.size(); i += 2)
            listOfPeople.add(new PeopleTask3(list.get(i), list.get(i + 1)));
        return listOfPeople;
    }

    public static PeopleCollector getInstance() {
        return new PeopleCollector();
    }

    @Override
    public Supplier<List<String>> supplier() {
        return ArrayList::new;
    }

    @Override
    public BiConsumer<List<String>, String> accumulator() {
        return List::add;
    }

    @Override
    public BinaryOperator<List<String>> combiner() {
        return this::combinerList;
    }

    private List<String> combinerList(List<String> list1, List<String> list2) {
        list1.addAll(list2);
        return list1;
    }

    @Override
    public Function<List<String>, List<PeopleTask3>> finisher() {
        return this::listOfPeople;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return EnumSet.of(Characteristics.CONCURRENT);
    }
}