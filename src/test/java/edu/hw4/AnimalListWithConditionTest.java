package edu.hw4;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import static edu.hw4.AnimalListWithCondition.animalWhoseCanBitesAndBelowMeterTask11;
import static edu.hw4.AnimalListWithCondition.animalWhoseNamesContainsMoreThanTwoWordTask13;
import static edu.hw4.AnimalListWithCondition.animalWhosePawsNotMatchWithAgeTask10;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AnimalListWithConditionTest {
    @Test
    public void animalWhoseCanBitesAndBelowMeterTest() {
        var animals = new Animal[] {
            new Animal("Marta", Animal.Type.CAT, Animal.Sex.F, 1, 101, 11, true),
            new Animal("Morty", Animal.Type.SPIDER, Animal.Sex.M, 12, 1, 11, true),
            new Animal("Flower", Animal.Type.BIRD, Animal.Sex.F, 4, 19, 2, false),
            new Animal("Felix", Animal.Type.DOG,Animal.Sex.M, 8,89,8,true)};
        var result = new ArrayList<Animal>();
        result.add(new Animal("Morty", Animal.Type.SPIDER, Animal.Sex.M, 12, 1, 11, true));
        result.add( new Animal("Felix", Animal.Type.DOG,Animal.Sex.M, 8,89,8,true));
        assertThat(animalWhoseCanBitesAndBelowMeterTask11(Arrays.stream(animals).toList())).isEqualTo(result);
    }
    @Test
    public void animalWhoseNamesContainsMoreThanTwoWordTest() {
        var res = new Animal("Marta Bla Bla", Animal.Type.CAT, Animal.Sex.F, 1, 100, 11, true);
        var animals = new Animal[] {
            res,
            new Animal("Morty", Animal.Type.SPIDER, Animal.Sex.M, 12, 1, 11, true),
            new Animal("Flower", Animal.Type.BIRD, Animal.Sex.F, 4, 19, 2, false),
            new Animal("Felix", Animal.Type.DOG,Animal.Sex.M, 8,46,8,true)};
        var result = new ArrayList<Animal>();
        result.add(res);
        assertThat(animalWhoseNamesContainsMoreThanTwoWordTask13(Arrays.stream(animals).toList())).isEqualTo(result);
    }
    @Test
    public void animalWhosePawsNotMatchWithAgeTest() {
        var res2 = new Animal("Flower", Animal.Type.BIRD, Animal.Sex.F, 10, 19, 2, false);
        var res1 = new Animal("Marta", Animal.Type.CAT, Animal.Sex.F, 1, 100, 11, true);
        var animals = new Animal[] {
            res1,
            new Animal("Morty", Animal.Type.SPIDER, Animal.Sex.M, 8, 1, 11, true),
            res2,
            new Animal("Felix", Animal.Type.DOG,Animal.Sex.M, 4,46,8,true)};
        var result =  new ArrayList<Animal>();
        result.add(res1);
        result.add(res2);
        assertThat(animalWhosePawsNotMatchWithAgeTask10(Arrays.stream(animals).toList())).isEqualTo(result);
    }
}
