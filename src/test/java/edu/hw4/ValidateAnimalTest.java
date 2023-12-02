package edu.hw4;

import edu.hw4.Validate.ValidationError;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import static edu.hw4.Validate.ValidateAnimal.animalWithMistakesTask19;
import static edu.hw4.Validate.ValidateAnimal.animalWithMistakesTask20;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ValidateAnimalTest {
    @Test
    public void animalWithMistakesTest() {
        var animals = new Animal[] {
            new Animal("Marta", Animal.Type.CAT, Animal.Sex.F, 1, 300, 11, true),
            new Animal("Morty", Animal.Type.SPIDER, Animal.Sex.M, 12, 1, 11, true),
            new Animal("Flower", Animal.Type.BIRD, Animal.Sex.F, 4, 19, 2, false),
            new Animal("Felix", Animal.Type.DOG,Animal.Sex.M, 8,46,8,true)};
        var result =  new HashMap<String, Set<ValidationError>>();
        var err = new HashSet<ValidationError>();
        err.add(new ValidationError("height", "Too big for dog|cat"));
        result.put("Marta", err);
        assertThat(animalWithMistakesTask19(Arrays.stream(animals).toList())).isEqualTo(result);
    }
    @Test
    public void animalWithMistakesSecondTaskTest() {
        var animals = new Animal[] {
            new Animal("Marta", Animal.Type.CAT, Animal.Sex.F, 1, 300, 11, true),
            new Animal("Morty", Animal.Type.SPIDER, Animal.Sex.M, 12, 1, 11, true),
            new Animal("Flower", Animal.Type.BIRD, Animal.Sex.F, 4, 19, 2, false),
            new Animal("Felix", Animal.Type.DOG,Animal.Sex.M, 8,46,8,true)};
        var result =  new HashMap<String, String>();
        result.put("Marta", "height");
        assertThat(animalWithMistakesTask20(Arrays.stream(animals).toList())).isEqualTo(result);
    }
}
