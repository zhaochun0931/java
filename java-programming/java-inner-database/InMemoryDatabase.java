import java.util.HashMap;
import java.util.Map;

public class InMemoryDatabase {
    private Map<String, String> database;

    public InMemoryDatabase() {
        database = new HashMap<>();
    }

    public void put(String key, String value) {
        database.put(key, value);
    }

    public String get(String key) {
        return database.get(key);
    }

    public boolean containsKey(String key) {
        return database.containsKey(key);
    }

    public void remove(String key) {
        database.remove(key);
    }

    public void clear() {
        database.clear();
    }

    public int size() {
        return database.size();
    }

    public static void main(String[] args) {
        InMemoryDatabase db = new InMemoryDatabase();

        // Add some key-value pairs
        db.put("key1", "value1");
        db.put("key2", "value2");
        db.put("key3", "value3");

        // Retrieve values
        System.out.println("Value for key1: " + db.get("key1"));
        System.out.println("Value for key2: " + db.get("key2"));

        // Check if key exists
        System.out.println("Contains key 'key1': " + db.containsKey("key1"));
        System.out.println("Contains key 'key4': " + db.containsKey("key4"));

        // Remove a key
        db.remove("key2");
        System.out.println("Value for key2 after removal: " + db.get("key2"));

        // Clear the database
        db.clear();
        System.out.println("Database size after clearing: " + db.size());
    }
}
