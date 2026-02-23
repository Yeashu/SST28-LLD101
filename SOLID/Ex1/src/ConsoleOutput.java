import java.util.List;

public class ConsoleOutput {
    public static void printInput(String s) {
        System.out.println("INPUT: " + s);
    }
    public static void printErrors(List<String> errors) {
        System.out.println("ERROR: cannot register");
        for (String e : errors) System.out.println("- " + e);
    }
    public static void printSavedStudent(StudentRecord rec, int total) {
        System.out.println("OK: created student " + rec.id);
        System.out.println("Saved. Total students: " + total);
        System.out.println("CONFIRMATION:");
        System.out.println(rec);
    }
}
