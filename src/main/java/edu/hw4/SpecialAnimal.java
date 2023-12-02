package edu.hw4;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class SpecialAnimal {
    private SpecialAnimal() {
    }

    public static Animal animalWithLongestNameTask4(List<Animal> original) {
        return original.stream().max(Comparator.comparingInt(animal -> animal.name().length())).orElse(null);
    }

    public static Animal oldestAnimalAtGivenPositionTask7(List<Animal> original, int position) {
        if (position < 0 || position >= original.size()) {
            return null;
        }
        return original.stream()
            .sorted((o1, o2) -> Integer.compare(o2.age(), o1.age()))
            .skip(position - 1)
            .toList().getFirst();
    }

    public static Optional<Animal> heaviestAnimalBelowGivenHeightTask8(List<Animal> original, int height) {
        return original.stream()
            .filter(animal -> animal.height() < height)
            .max(Comparator.comparingInt(Animal::weight));
    }

    public static Boolean anyDogWithHeightMoreThanGivenHeightTask14(List<Animal> original, int height) {
        return original.stream()
            .anyMatch(animal -> animal.type().equals(Animal.Type.DOG) && animal.height() > height);
    }

    public static Animal heaviestFishTask18(List<List<Animal>> original) {
        return original.stream()
            .flatMap(Collection::stream)
            .filter(animal -> animal.type().equals(Animal.Type.FISH))
            .max(Comparator.comparingInt(Animal::weight))
            .orElse(null);
    }
}
