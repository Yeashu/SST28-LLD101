import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Placement Eligibility ===");
        StudentProfile s = new StudentProfile("23BCS1001", "Ayaan", 8.10, 72, 18, LegacyFlags.NONE);
        // add eligibility rules in the list
        List<EligibilityRule> rules = new ArrayList<>();
        rules.add(new DisciplinaryRule());
        rules.add(new CGRRule());
        rules.add(new AttendanceRule());
        rules.add(new CreditRule());
        EligibilityEngine engine = new EligibilityEngine(new FakeEligibilityStore(), rules);
        engine.runAndPrint(s);
    }
}
