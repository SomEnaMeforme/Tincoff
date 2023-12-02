package edu.hw4.Validate;

import edu.hw4.Animal;
import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import static edu.hw4.Validate.Validator.validateAnimal;

public class ValidateAnimal {
    private ValidateAnimal() {
    }

    public static Map<String, Set<ValidationError>> animalWithMistakesTask19(List<Animal> original) {
        return original.stream().filter(x -> !validateAnimal(x).isEmpty())
            .collect(Collectors.toMap(Animal::name, Validator::validateAnimal));
    }

    public static Map<String, String> animalWithMistakesTask20(List<Animal> original) {
        return original.stream()
            .filter(x -> !validateAnimal(x).isEmpty())
            .collect(Collectors.toMap(Animal::name, Validator::validateAnimal))
            .entrySet().stream()
            .flatMap(e -> e.getValue().stream()
                .map(value -> new AbstractMap.SimpleEntry<>(e.getKey(), value.fieldName())))
            .collect(Collectors.toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue));
    }
}
