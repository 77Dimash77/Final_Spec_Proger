import java.util.ArrayList;
import java.util.List;

public class Animal {
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