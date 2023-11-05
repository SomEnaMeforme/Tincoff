package edu.hw4;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import static edu.hw4.AnimalCounter.animalCountWhoseWeightMoreThanHeightTask12;
import static edu.hw4.AnimalCounter.animalTypeCounterTask3;
import static edu.hw4.AnimalCounter.areSpidersBitesMoreOftenThanDogTask17;
import static edu.hw4.AnimalCounter.heaviestAnimalForEachTypeTask6;
import static edu.hw4.AnimalCounter.whichAnimalSexIsGreaterTask5;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AnimalCounterTest {
    @Test
    public void areSpidersBitesMoreOftenThanDogTest() {
        var animals = new Animal[] {
            new Animal("Marta", Animal.Type.SPIDER, Animal.Sex.F, 1, 100, 11, true),
            new Animal("Morty", Animal.Type.SPIDER, Animal.Sex.M, 12, 1, 11, true),
            new Animal("Flower", Animal.Type.BIRD, Animal.Sex.F, 4, 19, 2, false),
            new Animal("Felix", Animal.Type.DOG,Animal.Sex.M, 8,46,8,true)};
        assertThat(areSpidersBitesMoreOftenThanDogTask17(Arrays.stream(animals).toList())).isEqualTo(true);
    }
    @Test
    public void areSpidersBitesMoreOftenThanDogWhenSameDataTest() {
        var animals = new Animal[] {
            new Animal("Marta", Animal.Type.CAT, Animal.Sex.F, 1, 100, 11, true),
            new Animal("Morty", Animal.Type.SPIDER, Animal.Sex.M, 12, 1, 11, true),
            new Animal("Flower", Animal.Type.BIRD, Animal.Sex.F, 4, 19, 2, false),
            new Animal("Felix", Animal.Type.DOG,Animal.Sex.M, 8,46,8,true)};
        assertThat(areSpidersBitesMoreOftenThanDogTask17(Arrays.stream(animals).toList())).isEqualTo(false);
    }
    @Test
    public void animalCountWhoseWeightMoreThanHeightTest() {
        var animals = new Animal[] {
            new Animal("Marta", Animal.Type.CAT, Animal.Sex.F, 1, 100, 11, true),
            new Animal("Morty", Animal.Type.SPIDER, Animal.Sex.M, 12, 1, 11, true),
            new Animal("Flower", Animal.Type.BIRD, Animal.Sex.F, 4, 19, 2, false),
            new Animal("Felix", Animal.Type.DOG,Animal.Sex.M, 8,46,8,true)};
        assertThat(animalCountWhoseWeightMoreThanHeightTask12(Arrays.stream(animals).toList())).isEqualTo(1);
    }
    @Test
    public void countAnimalTypeTest() {
        var animals = new Animal[] {
            new Animal("Marta", Animal.Type.CAT, Animal.Sex.F, 1, 100, 11, true),
            new Animal("Morty", Animal.Type.SPIDER, Animal.Sex.M, 12, 1, 11, true),
            new Animal("Flower", Animal.Type.BIRD, Animal.Sex.F, 4, 19, 2, false),
            new Animal("Felix", Animal.Type.DOG,Animal.Sex.M, 8,46,8,true)};
        var result =  new HashMap<Animal.Type, Integer>();
        result.put(Animal.Type.CAT, 1);
        result.put(Animal.Type.SPIDER, 1);
        result.put(Animal.Type.BIRD, 1);
        result.put(Animal.Type.DOG, 1);
        assertThat(animalTypeCounterTask3(Arrays.stream(animals).toList())).isEqualTo(result);
    }
    @Test
    public void countAnimalTypeWhenTypeSameTest() {
        var animals = new Animal[] {
            new Animal("Marta", Animal.Type.CAT, Animal.Sex.F, 1, 100, 11, true),
            new Animal("Morty", Animal.Type.CAT, Animal.Sex.M, 12, 1, 11, true),
            new Animal("Flower", Animal.Type.BIRD, Animal.Sex.F, 4, 19, 2, false),
            new Animal("Felix", Animal.Type.BIRD,Animal.Sex.M, 8,46,8,true),
            new Animal("Felix", Animal.Type.BIRD,Animal.Sex.M, 8,46,8,true),
            new Animal("Felix", Animal.Type.BIRD,Animal.Sex.M, 8,46,8,true)};
        var result =  new HashMap<Animal.Type, Integer>();
        result.put(Animal.Type.CAT, 2);
        result.put(Animal.Type.BIRD, 4);
        assertThat(animalTypeCounterTask3(Arrays.stream(animals).toList())).isEqualTo(result);
    }
    @Test
    public void whichAnimalSexIsGreaterTest() {
        var animals = new Animal[] {
            new Animal("Marta", Animal.Type.CAT, Animal.Sex.F, 1, 100, 11, true),
            new Animal("Morty", Animal.Type.SPIDER, Animal.Sex.M, 12, 1, 11, true),
            new Animal("Flower", Animal.Type.BIRD, Animal.Sex.F, 4, 19, 2, false),
            new Animal("Felix", Animal.Type.DOG,Animal.Sex.F, 8,46,8,true)};
        assertThat(whichAnimalSexIsGreaterTask5(Arrays.stream(animals).toList())).isEqualTo(Animal.Sex.F);
    }
    @Test
    public void whichAnimalSexIsGreaterWhenHaveOneSexTest() {
        var animals = new Animal[] {
            new Animal("Marta", Animal.Type.CAT, Animal.Sex.F, 1, 100, 11, true),
            new Animal("Flower", Animal.Type.BIRD, Animal.Sex.F, 4, 19, 2, false)
        };
        assertThat(whichAnimalSexIsGreaterTask5(Arrays.stream(animals).toList())).isEqualTo(Animal.Sex.F);
    }
    @Test
    public void heaviestAnimalForEachTypeTest() {
        var heavyCat = new Animal("Marta", Animal.Type.CAT, Animal.Sex.F, 1, 100, 11, true);
        var heavySpider = new Animal("Morty", Animal.Type.SPIDER, Animal.Sex.M, 12, 1, 11, true);
        var animals = new Animal[] {
            heavyCat,
            heavySpider,
            new Animal("Flower", Animal.Type.SPIDER, Animal.Sex.F, 4, 19, 2, false),
            new Animal("Felix", Animal.Type.CAT,Animal.Sex.M, 8,46,8,true)};
        var result =  new HashMap<Animal.Type, Animal>();
        result.put(Animal.Type.CAT, heavyCat);
        result.put(Animal.Type.SPIDER, heavySpider);
        assertThat(heaviestAnimalForEachTypeTask6(Arrays.stream(animals).toList())).isEqualTo(result);
    }
}
