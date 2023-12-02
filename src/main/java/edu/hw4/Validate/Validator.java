package edu.hw4.Validate;

import edu.hw4.Animal;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Validator {
    private Validator() {
    }

    private static final int MAX_AGE = 100;
    private static final int MAX_HEIGHT_DOG_OR_CAT = 200;
    private static final int MAX_HEIGHT_SPIDER = 20;
    private static final int MAX_HEIGHT_BIRD = 35;
    private static final int MAX_WEIGHT = 50;

    public static ValidateResult validateWeight(Animal animal) {
        if (animal.weight() >= 0 && animal.weight() < MAX_WEIGHT) {
            return new ValidateResult(true, null);
        }
        var fieldName = "weight";
        return animal.weight() > 0
            ? new ValidateResult(false, new ValidationError(fieldName, "Too heavy for animal"))
            : new ValidateResult(false, new ValidationError(fieldName, "Weight cannot be negative"));
    }

    public static ValidateResult validateHeight(Animal animal) {
        var fieldName = "height";
        if (animal.height() < 0) {
            return new ValidateResult(
                false,
                new ValidationError(fieldName, "Height cannot be negative")
            );
        }
        if (animal.type().equals(Animal.Type.DOG) || animal.type().equals(Animal.Type.CAT)) {
            return validateHeightDogOrCat(animal, fieldName);
        } else if (animal.type().equals(Animal.Type.SPIDER)) {
            return validateHeightSpider(animal, fieldName);
        }
        return animal.type().equals(Animal.Type.BIRD)
            ? validateHeightBird(animal, fieldName)
            : new ValidateResult(true, null);
    }

    private static ValidateResult validateHeightDogOrCat(Animal animal, String fieldName) {
        if (animal.height() > MAX_HEIGHT_DOG_OR_CAT) {
            return new ValidateResult(false, new ValidationError(fieldName, "Too big for dog|cat"));
        }
        return new ValidateResult(true, null);
    }

    private static ValidateResult validateHeightSpider(Animal animal, String fieldName) {
        if (animal.height() > MAX_HEIGHT_SPIDER) {
            return new ValidateResult(false, new ValidationError(fieldName, "Too big for spider"));
        }
        return new ValidateResult(true, null);
    }

    private static ValidateResult validateHeightBird(Animal animal, String fieldName) {
        if (animal.height() > MAX_HEIGHT_BIRD) {
            return new ValidateResult(false, new ValidationError(fieldName, "Too big for bird"));
        }
        return new ValidateResult(true, null);
    }

    public static ValidateResult validateBites(Animal animal) {
        if (animal.bites() && animal.type().equals(Animal.Type.BIRD)) {
            return new ValidateResult(false, new ValidationError("bites", "Birds don't bite"));
        }
        return new ValidateResult(true, null);

    }

    public static ValidateResult validateAge(Animal animal) {
        if (animal.age() >= 0 && animal.age() < MAX_AGE) {
            return new ValidateResult(true, null);
        }
        var fieldName = "age";
        return animal.age() > 0
            ? new ValidateResult(false, new ValidationError(fieldName, "Too old for animal"))
            : new ValidateResult(false, new ValidationError(fieldName, "Age cannot be negative"));
    }

    public static Set<ValidationError> validateAnimal(Animal animal) {
        var res1 = validateWeight(animal);
        var res2 = validateHeight(animal);
        var res3 = validateAge(animal);
        var res4 = validateBites(animal);
        var coll = new ValidateResult[] {res1, res2, res3, res4};
        return Arrays.stream(coll).filter(result -> !result.isValid).map(res -> res.error).collect(Collectors.toSet());
    }

    public record ValidateResult(Boolean isValid, ValidationError error) {
    }
}
