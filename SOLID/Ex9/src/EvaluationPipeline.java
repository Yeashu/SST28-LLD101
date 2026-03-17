public class EvaluationPipeline {
    IPlagiarismChecker pc;
    IGrader grader;
    IReportWriter writer;
    Rubric rubric;

    public EvaluationPipeline(IPlagiarismChecker pc, IGrader grader, IReportWriter writer, Rubric rubric) {
        this.pc = pc;
        this.grader = grader;
        this.writer = writer;
        this.rubric = rubric;
    }

    // Fixed: DIP violation: high-level module constructs concretes directly
    public void evaluate(Submission sub) {
        // Rubric rubric = new Rubric();
        // PlagiarismChecker pc = new PlagiarismChecker();
        // CodeGrader grader = new CodeGrader();
        // ReportWriter writer = new ReportWriter();

        int plag = pc.check(sub);
        System.out.println("PlagiarismScore=" + plag);

        int code = grader.grade(sub, rubric);
        System.out.println("CodeScore=" + code);

        String reportName = writer.write(sub, plag, code);
        System.out.println("Report written: " + reportName);

        int total = plag + code;
        String result = (total >= 90) ? "PASS" : "FAIL";
        System.out.println("FINAL: " + result + " (total=" + total + ")");
    }
}
