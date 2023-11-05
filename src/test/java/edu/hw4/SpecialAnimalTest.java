package edu.hw4;

import org.junit.jupiter.api.Test;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static edu.hw4.SpecialAnimal.animalWithLongestNameTask4;
import static edu.hw4.SpecialAnimal.anyDogWithHeightMoreThanGivenHeightTask14;
import static edu.hw4.SpecialAnimal.heaviestAnimalBelowGivenHeightTask8;
import static edu.hw4.SpecialAnimal.heaviestFishTask18;
import static edu.hw4.SpecialAnimal.oldestAnimalAtGivenPositionTask7;
import static java.util.Arrays.asList;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SpecialAnimalTest {
    @Test
    public void heaviestFishTest() {
        var result = new Animal("Flower", Animal.Type.FISH, Animal.Sex.F, 4, 19, 21, false);
        var animals1 = new Animal[] {
            new Animal("Marta", Animal.Type.FISH, Animal.Sex.F, 1, 100, 11, true),
            new Animal("Morty", Animal.Type.SPIDER, Animal.Sex.M, 12, 1, 1, true),
            result,
            new Animal("Felix", Animal.Type.DOG,Animal.Sex.M, 8,46,8,true)};
        var animals2 = new Animal[] {
            new Animal("Marta", Animal.Type.CAT, Animal.Sex.F, 1, 100, 11, true),
            new Animal("Morty", Animal.Type.FISH, Animal.Sex.M, 12, 1, 1, true),
            new Animal("Felix", Animal.Type.FISH,Animal.Sex.M, 8,46,8,true)};
        var animals = new ArrayList<List<Animal>>();
        animals.add(asList(animals1));
        animals.add(asList(animals2));
        assertThat(heaviestFishTask18(animals)).isEqualTo(result);
    }
    @Test
    public void anyDogWithHeightMoreThanGivenHeightTest() {
        var result = new Animal("Flower", Animal.Type.BIRD, Animal.Sex.F, 4, 19, 2, false);
        var animals = new Animal[] {
            new Animal("Marta", Animal.Type.CAT, Animal.Sex.F, 1, 100, 11, true),
            new Animal("Morty", Animal.Type.SPIDER, Animal.Sex.M, 12, 1, 1, true),
            result,
            new Animal("Felix", Animal.Type.DOG,Animal.Sex.M, 8,46,8,true)};
        assertThat(anyDogWithHeightMoreThanGivenHeightTask14(Arrays.stream(animals).toList(), 40)).isEqualTo(true);
    }
    @Test
    public void heaviestAnimalBelowGivenHeightTest() {
        var result = new Animal("Flower", Animal.Type.BIRD, Animal.Sex.F, 4, 19, 2, false);
        var animals = new Animal[] {
            new Animal("Marta", Animal.Type.CAT, Animal.Sex.F, 1, 100, 11, true),
            new Animal("Morty", Animal.Type.SPIDER, Animal.Sex.M, 12, 1, 1, true),
            result,
            new Animal("Felix", Animal.Type.DOG,Animal.Sex.M, 8,46,8,true)};
        assertThat(heaviestAnimalBelowGivenHeightTask8(Arrays.stream(animals).toList(), 40).get()).isEqualTo(result);
    }
    @Test
    public void animalWithLongestNameTest() {
        var animalWithLongestName = new Animal("Flower", Animal.Type.BIRD, Animal.Sex.F, 4, 19, 2, false);
        var animals = new Animal[] {
            new Animal("Marta", Animal.Type.CAT, Animal.Sex.F, 1, 100, 11, true),
            new Animal("Morty", Animal.Type.SPIDER, Animal.Sex.M, 12, 1, 11, true),
           animalWithLongestName,
            new Animal("Felix", Animal.Type.DOG,Animal.Sex.M, 8,46,8,true)};
        assertThat(animalWithLongestNameTask4(Arrays.stream(animals).toList())).isEqualTo(animalWithLongestName);
    }
    @Test
    public void oldestAnimalAtGivenPosition() {
        var result = new Animal("Felix", Animal.Type.DOG,Animal.Sex.M, 8,46,8,true);
        var animals = new Animal[] {
            new Animal("Marta", Animal.Type.CAT, Animal.Sex.F, 1, 100, 11, true),
            new Animal("Morty", Animal.Type.SPIDER, Animal.Sex.M, 12, 1, 11, true),
            new Animal("Flower", Animal.Type.BIRD, Animal.Sex.F, 4, 19, 2, false),
            result};
        assertThat(oldestAnimalAtGivenPositionTask7(Arrays.stream(animals).toList(), 2)).isEqualTo(result);
    }
    @Test
    public void oldestAnimalAtGivenPositionWhenPositionMoreThanLength() {
        var result = new Animal("Morty", Animal.Type.SPIDER, Animal.Sex.M, 12, 1, 11, true);
        var animals = new Animal[] {
            new Animal("Marta", Animal.Type.CAT, Animal.Sex.F, 1, 100, 11, true),
            result,
            new Animal("Flower", Animal.Type.BIRD, Animal.Sex.F, 4, 19, 2, false),
            new Animal("Felix", Animal.Type.DOG,Animal.Sex.M, 8,46,8,true)};
        assertThat(oldestAnimalAtGivenPositionTask7(Arrays.stream(animals).toList(), 5)).isEqualTo(null);
    }
}
