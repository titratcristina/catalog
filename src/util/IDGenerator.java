package util;

public class IDGenerator {
    private static int nextID = 1;

    public static int generateID() {
        return nextID++;
    }
}