public class CsvExporter extends Exporter {
    // public ExportResult export(ExportRequest req) {
    //     // LSP issue: changes meaning by lossy conversion
    //     String body = req.body == null ? "" : req.body.replace("\n", " ").replace(",", " ");
    //     String csv = "title,body\n" + req.title + "," + body + "\n";
    //     return new ExportResult("text/csv", csv.getBytes(StandardCharsets.UTF_8));
    // }

    @Override
    protected ExportRequest getNormalizeReq(ExportRequest req) {
        String body = req.body == null ? "" : req.body.replace("\n", " ").replace(",", " ");
        return new ExportRequest(req.title, body);
    }

    @Override
    public String getContentType() {
        return "text/csv";
    }

    @Override
    public String getEncodedContent(ExportRequest normReq) {
        return "title,body\n" + normReq.title + "," + normReq.body + "\n";
    }
}
