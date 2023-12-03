import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class AnimalRegistry {
    private List<Animal> animals = new ArrayList<>();

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public void addCommand(int animalId, String command) {
        Animal animal = findAnimalById(animalId);
        if (animal != null) {
            animal.addCommand(command);
            System.out.println("Command added successfully!");
        } else {
            System.out.println("Animal not found with ID: " + animalId);
        }
    }

    public void printAnimals() {
        System.out.println("Animal Registry:");
        for (Animal animal : animals) {
            System.out.println(animal);
        }
        System.out.println("Total number of animals: " + Animal.getCount());
    }

    public void printAnimalsByDate() {
        System.out.println("Animal Registry by Date:");
        List<Animal> sortedAnimals = new ArrayList<>(animals);
        Collections.sort(sortedAnimals, Comparator.comparing(a -> a.dateOfBirth));
        for (Animal animal : sortedAnimals) {
            System.out.println(animal);
        }
        System.out.println("Total number of animals: " + Animal.getCount());
    }

    public void printAnimalsByName() {
        System.out.println("Animal Registry by Name:");
        List<Animal> sortedAnimals = new ArrayList<>(animals);
        Collections.sort(sortedAnimals, Comparator.comparing(a -> a.name));
        for (Animal animal : sortedAnimals) {
            System.out.println(animal);
        }
        System.out.println("Total number of animals: " + Animal.getCount());
    }

    private Animal findAnimalById(int id) {
        for (Animal animal : animals) {
            if (animal.id == id) {
                return animal;
            }
        }
        return null;
    }
}
