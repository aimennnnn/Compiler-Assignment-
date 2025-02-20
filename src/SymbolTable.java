import java.util.HashMap;
import java.util.Map;

public class SymbolTable {
    private static final Map<String, String> table = new HashMap<>();
    private static final Map<String, String> constants = new HashMap<>();

    public static void add(String name, String type) {
        if (!name.matches("[a-z]+")) {
            throw new RuntimeException("Invalid identifier: " + name + ". Identifiers must be lowercase.");
        }
        table.put(name, type);
    }

    public static void addConstant(String name, String type, String value) {
        if (!name.matches("[a-z]+")) {
            throw new RuntimeException("Invalid constant name: " + name + ". Identifiers must be lowercase.");
        }
        constants.put(name, type + ":" + value);
    }

    public static void printTable() {
        System.out.println("Symbol Table:");
        for (var entry : table.entrySet()) {
            System.out.println("Identifier: " + entry.getKey() + " | Type: " + entry.getValue());
        }
        System.out.println("Constants:");
        for (var entry : constants.entrySet()) {
            System.out.println("Constant: " + entry.getKey() + " | Type:Value = " + entry.getValue());
        }
    }
}
