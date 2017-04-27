package database.utilities;

/**
 * Created by Kevin on 3/25/2017.
 */
public class IdGenerator {
    private static int id = 0;

    public synchronized static int getID() {
        id++;
        return id;
    }

    public static void setId(int id) {
        IdGenerator.id = id;
    }
}
