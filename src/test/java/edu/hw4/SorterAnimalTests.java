package edu.hw4;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static edu.hw4.AnimalSorter.sortAnimalByHeightTask1;
import static edu.hw4.AnimalSorter.sortAnimalByTypeSexAndNameTask16;
import static edu.hw4.AnimalSorter.sortAnimalByWeightTask2;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SorterAnimalTests {
    @Test
    public void sortAnimalByHeightTest() {
        var animals = new Animal[] {
            new Animal("Felix", Animal.Type.CAT, Animal.Sex.M, 12, 1, 11, false),
            new Animal("Felix", Animal.Type.SPIDER, Animal.Sex.M, 12, 40, 6, false),
            new Animal("Felix", Animal.Type.DOG,Animal.Sex.F, 12,46,8,true)};
        assertThat(sortAnimalByHeightTask1(Arrays.stream(animals).toList()).toArray()).isEqualTo(
            new Animal[] {
                new Animal(
                    "Felix", Animal.Type.CAT, Animal.Sex.M, 12, 1, 11, false),
                new Animal(
                    "Felix", Animal.Type.SPIDER, Animal.Sex.M, 12, 40, 6, false),
                new Animal(
                    "Felix", Animal.Type.DOG,Animal.Sex.F, 12,46,8,true)});
    }

    @Test
    public void sortAnimalByWeightTest() {
        var animals = new Animal[] {
            new Animal("Felix", Animal.Type.CAT, Animal.Sex.M, 12, 1, 11, false),
            new Animal("Felix", Animal.Type.SPIDER, Animal.Sex.M, 12, 40, 6, false),
            new Animal("Felix", Animal.Type.DOG,Animal.Sex.F, 12,46,8,true)};
        assertThat(sortAnimalByWeightTask2(Arrays.stream(animals).toList(), 2).toArray()).isEqualTo(
            new Animal[] {
                new Animal("Felix", Animal.Type.CAT, Animal.Sex.M, 12, 1, 11, false),
                new Animal("Felix", Animal.Type.DOG,Animal.Sex.F, 12,46,8,true)
            }
        );
    }
    @Test
    public void sortAnimalByWeightWhenKMoreThanLengthTest() {
        var animals = new Animal[] {
            new Animal("Felix", Animal.Type.CAT, Animal.Sex.M, 12, 1, 11, false),
            new Animal("Felix", Animal.Type.SPIDER, Animal.Sex.M, 12, 40, 6, false),
            new Animal("Felix", Animal.Type.DOG,Animal.Sex.F, 12,46,8,true)};
        assertThat(sortAnimalByWeightTask2(Arrays.stream(animals).toList(), 4).toArray()).isEqualTo(
            new Animal[] {
                new Animal("Felix", Animal.Type.CAT, Animal.Sex.M, 12, 1, 11, false),
                new Animal("Felix", Animal.Type.DOG,Animal.Sex.F, 12,46,8,true),
                new Animal("Felix", Animal.Type.SPIDER, Animal.Sex.M, 12, 40, 6, false)
            }
        );
    }

    @Test
    public void sortAnimalByTypeSexAndNameTest() {
        var animals = new Animal[] {
            new Animal("Felix", Animal.Type.CAT, Animal.Sex.M, 12, 1, 11, false),
            new Animal("Felix", Animal.Type.SPIDER, Animal.Sex.M, 12, 40, 6, false),
            new Animal("Felix", Animal.Type.DOG,Animal.Sex.F, 12,46,8,true)};
        assertThat(sortAnimalByTypeSexAndNameTask16(Arrays.stream(animals).toList()).toArray()).isEqualTo(
            new Animal[] {
                new Animal("Felix", Animal.Type.CAT, Animal.Sex.M, 12, 1, 11, false),
                new Animal("Felix", Animal.Type.DOG,Animal.Sex.F, 12,46,8,true),
                new Animal("Felix", Animal.Type.SPIDER, Animal.Sex.M, 12, 40, 6, false)
            }
        );
    }
    @Test
    public void sortAnimalByTypeSexAndNameWhenTypeSameTest() {
        var animals = new Animal[] {
            new Animal("Felix", Animal.Type.SPIDER, Animal.Sex.F, 12, 40, 6, false),
            new Animal("Morty", Animal.Type.SPIDER, Animal.Sex.M, 12, 1, 11, false)
        };
        assertThat(sortAnimalByTypeSexAndNameTask16(Arrays.stream(animals).toList()).toArray()).isEqualTo(
            new Animal[] {
                new Animal("Morty", Animal.Type.SPIDER, Animal.Sex.M, 12, 1, 11, false),
                new Animal("Felix", Animal.Type.SPIDER, Animal.Sex.F, 12, 40, 6, false)
            }
        );
    }
    @Test
    public void sortAnimalByTypeSexAndNameWhenTypeAndSexSameTest() {
        var animals = new Animal[] {
            new Animal("Felix", Animal.Type.SPIDER, Animal.Sex.M, 12, 1, 11, false),
            new Animal("Morty", Animal.Type.SPIDER, Animal.Sex.M, 12, 40, 6, false)
        };
        assertThat(sortAnimalByTypeSexAndNameTask16(Arrays.stream(animals).toList()).toArray()).isEqualTo(
            new Animal[] {
                new Animal("Felix", Animal.Type.SPIDER, Animal.Sex.M, 12, 1, 11, false),
                new Animal("Morty", Animal.Type.SPIDER, Animal.Sex.M, 12, 40, 6, false)
            }
        );
    }
}
