public class CreditRule implements EligibilityRule {
    @Override
    public boolean evaluate(StudentProfile student) {
        return student.earnedCredits >= 20;
    }

    @Override
    public String getFailureReason() {
        return "credits earned below 20";
    }
    
}
