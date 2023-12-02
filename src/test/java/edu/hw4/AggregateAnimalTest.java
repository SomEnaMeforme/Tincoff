package edu.hw4;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.HashMap;
import static edu.hw4.AggregateAnimal.pawsSumTask9;
import static edu.hw4.AggregateAnimal.sumWeightTypeAnimalTask15;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AggregateAnimalTest {
    @Test
    public void pawsSumTest() {
        var animals = new Animal[] {
            new Animal("Marta", Animal.Type.CAT, Animal.Sex.F, 1, 100, 11, true),
            new Animal("Morty", Animal.Type.SPIDER, Animal.Sex.M, 12, 1, 11, true),
            new Animal("Flower", Animal.Type.BIRD, Animal.Sex.F, 4, 19, 2, false),
            new Animal("Felix", Animal.Type.DOG,Animal.Sex.M, 8,46,8,true)};
        assertThat(pawsSumTask9(Arrays.stream(animals).toList())).isEqualTo(18);
    }
    @Test
    public void sumWeightTypeAnimalTest() {
        var animals = new Animal[] {
            new Animal("Marta", Animal.Type.CAT, Animal.Sex.F, 1, 100, 11, true),
            new Animal("Morty", Animal.Type.SPIDER, Animal.Sex.M, 12, 1, 11, true),
            new Animal("Flower", Animal.Type.BIRD, Animal.Sex.F, 4, 19, 2, false),
            new Animal("Flowr", Animal.Type.BIRD, Animal.Sex.F, 6, 19, 3, false),
            new Animal("Fler", Animal.Type.CAT, Animal.Sex.F, 9, 19, 2, false),
            new Animal("Foer", Animal.Type.BIRD, Animal.Sex.F, 10, 19, 2, false),
            new Animal("Felix", Animal.Type.DOG,Animal.Sex.M, 8,46,8,true)};
        var result =  new HashMap<Animal.Type, Integer>();
        result.put(Animal.Type.CAT, 2);
        result.put(Animal.Type.BIRD, 5);
        result.put(Animal.Type.DOG, 8);
        assertThat(sumWeightTypeAnimalTask15(Arrays.stream(animals).toList(), 5, 10)).isEqualTo(result);
    }
}
