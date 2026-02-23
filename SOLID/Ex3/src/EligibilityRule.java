public interface EligibilityRule {
    boolean evaluate(StudentProfile student);
    String getFailureReason();
}
