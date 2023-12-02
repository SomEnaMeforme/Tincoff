package edu.hw4;

import java.util.List;

public class AnimalListWithCondition {
    private AnimalListWithCondition() {
    }

    private static final int METER = 100;

    public static List<Animal> animalWhosePawsNotMatchWithAgeTask10(List<Animal> original) {
        return original.stream().filter(animal -> animal.paws() != animal.age()).toList();
    }

    public static List<Animal> animalWhoseCanBitesAndBelowMeterTask11(List<Animal> original) {
        return original.stream().filter(animal -> animal.bites() && animal.height() < METER).toList();
    }

    public static List<Animal> animalWhoseNamesContainsMoreThanTwoWordTask13(List<Animal> original) {
        return original.stream().filter(animal -> animal.name().split(" ").length > 2).toList();
    }
}
