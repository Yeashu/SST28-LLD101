public class CGRRule implements EligibilityRule {
    @Override
    public boolean evaluate(StudentProfile student) {
        return student.cgr >= 8.0;
    }

    @Override
    public String getFailureReason() {
        return "CGR below 8.0";
    }
    
}
