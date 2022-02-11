package circus;

import circus.animal.*;
import circus.stuff.Cannon;
import circus.stuff.Equipment;
import circus.stuff.Ladder;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;

public class Circus {
    private static Animal[] animals = {
            new Duck("Drake"),
            new Parrot("Polly"),
            new Tiger("Tai Lung")
    };
    private static Equipment[] equipments = {
            new Ladder(50),
            new Cannon(5),
            new Cannon(100)
    };

    private static void makeAnimalsTalk() {
        for (Animal a : animals) {
            System.out.println(a);
            System.out.println(a.speak());
        }
    }

    private static int calculateAssetValue(Asset[] assets) {
        int total = 0;
        for (Asset a : assets) {
            if (a.getValue() <= 5) {
                System.out.println("Ignoring low value item: " + a.getValue());
                continue;
            }
            total += a.getValue();
            System.out.println("Adding item value: " + a.getValue());
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println("Number of animals : " + animals.length);
        //makeAnimalsTalk();
        //System.out.println("Total value of animals " + calculateAssetValue(animals));
        //System.out.println("Total value of equipments " + calculateAssetValue(equipments));
        //animals[3] = new Tiger("Dan");
        ArrayList<Animal> animalArrayList = new ArrayList<>(Arrays.asList(animals));
        printAllAnimals(animalArrayList);
        System.out.println("Number of animals in the array list: " + animalArrayList.size());
        animalArrayList.add(new Duck("Goby"));
        animalArrayList.add(new Parrot("Golly"));
        System.out.println("Number of animals in the array list: " + animalArrayList.size());
        printAllAnimals(animalArrayList);

        Duck louie = new Duck("Louie");
        Elephant ken = new Elephant("Ken");
        Parrot andy = new Parrot("Andy");

        animalArrayList.add(louie);
        animalArrayList.add(ken);
        animalArrayList.add(andy);
        printAllAnimals(animalArrayList);

        System.out.println("Position of Louie is : " + (animalArrayList.indexOf(louie)+1));
        System.out.println("\nBefore sorting:");
        printAllAnimals(animalArrayList);

        animalArrayList.sort(Animal.AnimalNameComparator);
        System.out.println("\nAfter sorting:");
        printAllAnimals(animalArrayList);
    }

    private static void printAllAnimals(ArrayList<Animal> animalArrayList) {
        for (Animal a: animalArrayList) {
            System.out.println(a);
        }
    }
}
