package edu.hw4;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import static java.util.function.UnaryOperator.identity;

public class AnimalCounter {
    private AnimalCounter() {
    }

    public static Map<Animal.Type, Integer> animalTypeCounterTask3(List<Animal> original) {
        return original.stream()
            .collect(Collectors.groupingBy(Animal::type, Collectors.summingInt(animal -> 1)));
    }

    public static Animal.Sex whichAnimalSexIsGreaterTask5(List<Animal> original) {
        return original.stream()
            .collect(Collectors
                .groupingBy(Animal::sex, Collectors
                    .summingInt(animal -> 1)))
            .entrySet().stream()
            .max(Map.Entry.comparingByValue()).get().getKey();
    }

    public static Map<Animal.Type, Animal> heaviestAnimalForEachTypeTask6(List<Animal> original) {
        return original.stream()
            .collect(Collectors.toMap(
                Animal::type,
                identity(),
                BinaryOperator.maxBy(Comparator.comparingInt(Animal::weight))
            ));
    }

    public static Integer animalCountWhoseWeightMoreThanHeightTask12(List<Animal> original) {
        return Long.valueOf(original.stream().filter(animal -> animal.weight() > animal.height()).count()).intValue();
    }

    public static Boolean areSpidersBitesMoreOftenThanDogTask17(List<Animal> original) {
        var haveDataForResearch = original.stream().anyMatch(AnimalCounter::isDogOrSpider);
        return haveDataForResearch
            && original.stream()
            .filter(AnimalCounter::isDogOrSpider)
            .collect(Collectors
                .groupingBy(Animal::type))
            .entrySet().stream()
            .map(list -> new Pair(
                list.getKey(),
                (double) list.getValue().stream()
                    .filter(Animal::bites)
                    .count()
                    / list.getValue().size()
            ))
            .max(Comparator.comparingDouble(Pair::frequency)
                .thenComparing((p1, p2) -> p2.type.compareTo(p1.type)))
            .get()
            .type.equals(Animal.Type.SPIDER);
    }

    private static Boolean isDogOrSpider(Animal animal) {
        return animal.type().equals(Animal.Type.DOG)
            || animal.type().equals(Animal.Type.SPIDER);
    }

    private record Pair(Animal.Type type, double frequency) {
    }
}
