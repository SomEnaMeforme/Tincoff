package edu.hw4;

import java.util.Comparator;
import java.util.List;

public class AnimalSorter {
    private AnimalSorter() {
    }

    public static List<Animal> sortAnimalByHeightTask1(List<Animal> original) {
        return original.stream()
            .sorted(Comparator.comparingInt(Animal::height))
            .toList();
    }

    public static List<Animal> sortAnimalByWeightTask2(List<Animal> original, int animalCount) {
        return original.stream()
            .sorted((o1, o2) -> Integer.compare(o2.weight(), o1.weight()))
            .limit(animalCount).toList();
    }

    public static List<Animal> sortAnimalByTypeSexAndNameTask16(List<Animal> original) {
        return original.stream()
            .sorted(Comparator.comparing(Animal::type).thenComparing(Animal::sex).thenComparing(Animal::name))
            .toList();
    }
}
