
import java.util.Scanner;


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
