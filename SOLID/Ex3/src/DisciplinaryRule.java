public class DisciplinaryRule implements EligibilityRule {
    @Override
    public boolean evaluate(StudentProfile student) {
        return student.disciplinaryFlag == LegacyFlags.NONE;
    }

    @Override
    public String getFailureReason() {
        return "disciplinary flag present";
    }
    
}
