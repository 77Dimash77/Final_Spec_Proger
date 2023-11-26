import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Animal {
    private static int count = 0;
    protected int id;
    protected String name;
    protected String dateOfBirth;
    protected List<String> commands = new ArrayList<>();

    public Animal(String name, String dateOfBirth) {
        this.id = ++count;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public void performCommand(String command) {
        System.out.println(name + " is performing command: " + command);
    }

    public void addCommand(String command) {
        commands.add(command);
    }

    public List<String> getCommands() {
        return commands;
    }

    public static int getCount() {
        return count;
    }

    public String toString() {
        return "[" + id + "] " + name + " - " + dateOfBirth + ", Commands: " + commands;
    }
}

class Pet extends Animal {
    public Pet(String name, String dateOfBirth) {
        super(name, dateOfBirth);
    }
}

class Dog extends Pet {
    public Dog(String name, String dateOfBirth) {
        super(name, dateOfBirth);
    }
}

class Cat extends Pet {
    public Cat(String name, String dateOfBirth) {
        super(name, dateOfBirth);
    }
}

class Hamster extends Pet {
    public Hamster(String name, String dateOfBirth) {
        super(name, dateOfBirth);
    }
}

class PackAnimal extends Animal {
    public PackAnimal(String name, String dateOfBirth) {
        super(name, dateOfBirth);
    }
}

class Horse extends PackAnimal {
    public Horse(String name, String dateOfBirth) {
        super(name, dateOfBirth);
    }
}

class Donkey extends PackAnimal {
    public Donkey(String name, String dateOfBirth) {
        super(name, dateOfBirth);
    }
}

class Camel extends PackAnimal {
    public Camel(String name, String dateOfBirth) {
        super(name, dateOfBirth);
    }
}

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

public class Final_JAVA_Animal {
    public static void main(String[] args) {
        AnimalRegistry animalRegistry = new AnimalRegistry();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("\nMenu:");
                System.out.println("1. Add new animal");
                System.out.println("2. Add command to an animal");
                System.out.println("3. Print animals");
                System.out.println("4. Print animals by date of birth");
                System.out.println("5. Print animals by name");
                System.out.println("6. Exit");

                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter animal type (Dog/Cat/Hamster/Horse/Donkey/Camel): ");
                        String animalType = scanner.next();
                        System.out.print("Enter name: ");
                        String name = scanner.next();
                        System.out.print("Enter date of birth (YYYY-MM-DD): ");
                        String dateOfBirth = scanner.next();

                        Animal newAnimal;
                        switch (animalType.toLowerCase()) {
                            case "dog":
                                newAnimal = new Dog(name, dateOfBirth);
                                break;
                            case "cat":
                                newAnimal = new Cat(name, dateOfBirth);
                                break;
                            case "hamster":
                                newAnimal = new Hamster(name, dateOfBirth);
                                break;
                            case "horse":
                                newAnimal = new Horse(name, dateOfBirth);
                                break;
                            case "donkey":
                                newAnimal = new Donkey(name, dateOfBirth);
                                break;
                            case "camel":
                                newAnimal = new Camel(name, dateOfBirth);
                                break;
                            default:
                                System.out.println("Invalid animal type. Please try again.");
                                continue;
                        }
                        animalRegistry.addAnimal(newAnimal);
                        System.out.println("New animal added successfully!");
                        break;

                    case 2:
                        System.out.print("Enter animal ID: ");
                        int animalId = scanner.nextInt();
                        System.out.print("Enter command: ");
                        String command = scanner.next();
                        animalRegistry.addCommand(animalId, command);
                        break;

                    case 3:
                        animalRegistry.printAnimals();
                        break;

                    case 4:
                        animalRegistry.printAnimalsByDate();
                        break;

                    case 5:
                        animalRegistry.printAnimalsByName();
                        break;

                    case 6:
                        System.out.println("Exiting the program. Goodbye!");
                        scanner.close();
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                scanner.nextLine();
            }
        }
    }
}
