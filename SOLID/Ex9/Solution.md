How I solved the issues:
There was dependency inversion issue which I solved by creating abstraction and injecting dependency in EvaluationPipeline through constructor
```java
interface IGrader {
    int grade(Submission s, Rubric r);
}
interface IPlagiarismChecker {
    int check(Submission s);
}
interface IReportWriter {
    String write(Submission s, int plag, int code);
}
```
```java

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
```
