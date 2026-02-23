public class AttendanceRule implements EligibilityRule {
    @Override
    public boolean evaluate(StudentProfile student) {
        return student.attendancePct >= 75;
    }

    @Override
    public String getFailureReason() {
        return "attendance below 75";
    }
    
}
