How I solved it:
Applied Interface Segregation Principle and splitted the fat interface to managable ones based on use-case:

// public interface ClubAdminTools {
//     // Fat interface (ISP violation)
//     void addIncome(double amt, String note);
//     void addExpense(double amt, String note);
//     void addMinutes(String text);
//     void createEvent(String name, double budget);
//     int getEventsCount();
// }

interface FinanceTools {
    void addIncome(double amt, String note);
    void addExpense(double amt, String note);  
}

interface MinutesTool {
    void addMinutes(String text);
}

interface EventTool {
    void createEvent(String name, double budget);
    int getEventsCount();
}
