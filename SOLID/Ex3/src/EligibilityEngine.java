import java.util.*;

public class EligibilityEngine {
    private final FakeEligibilityStore store;
    private final List<EligibilityRule> rules;

    public EligibilityEngine(FakeEligibilityStore store, List<EligibilityRule> rules) {
        this.store = store;
        this.rules = rules;
    }

    public void runAndPrint(StudentProfile s) {
        ReportPrinter p = new ReportPrinter();
        EligibilityEngineResult r = evaluate(s, rules); // giant conditional inside
        p.print(s, r);
        store.save(s.rollNo, r.status);
    }

    public EligibilityEngineResult evaluate(StudentProfile s, List<EligibilityRule> rules) {
        List<String> reasons = new ArrayList<>();
        String status = "ELIGIBLE";

        // OCP violation: long chain for each rule now removed with interface and rules list
        
        for (EligibilityRule rule : rules) {
            if (!rule.evaluate(s)) {
                status = "NOT_ELIGIBLE";
                reasons.add(rule.getFailureReason());
                break;
            }
        }

        return new EligibilityEngineResult(status, reasons);
    }
}

class EligibilityEngineResult {
    public final String status;
    public final List<String> reasons;
    public EligibilityEngineResult(String status, List<String> reasons) {
        this.status = status;
        this.reasons = reasons;
    }
}
