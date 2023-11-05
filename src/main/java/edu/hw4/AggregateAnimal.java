package edu.hw4;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AggregateAnimal {
    private AggregateAnimal() {
    }

    public static Integer pawsSumTask9(List<Animal> original) {
        return original.stream().map(Animal::paws).reduce(Integer::sum).orElse(-1);
    }

    public static Map<Animal.Type, Integer> sumWeightTypeAnimalTask15(List<Animal> original, int minAge, int maxAge) {
        return original.stream().filter(animal -> animal.age() >= minAge && animal.age() <= maxAge)
            .collect(Collectors.groupingBy(Animal::type, Collectors.summingInt(Animal::weight)));
    }
}
