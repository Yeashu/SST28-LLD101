import java.util.*;

public class OnboardingService {
    private final Database db;
    private final Parser pr;
    private final Validator val;

    public OnboardingService(Database db) {
        this.db = db; 
        this.pr = new Parser();
        this.val = new Validator();
    }

    // Intentionally violated SRP: parses + validates + creates ID + saves + prints. Now fixed using parser, validator class with database interface.
    public void registerFromRawInput(String raw){
        ConsoleOutput.printInput(raw);

        ParsedRecord pRecord = pr.parse(raw);
        List<String> errors = val.validate(pRecord);

        if (!errors.isEmpty()) {
            ConsoleOutput.printErrors(errors);
            return;
        }

        StudentRecord rec = new StudentRecord(IdUtil.nextStudentId(db.count()), pRecord);
        db.save(rec);
        ConsoleOutput.printSavedStudent(rec, db.count());
    }
}
