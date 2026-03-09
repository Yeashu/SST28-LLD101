public class PdfExporter extends Exporter {
    // @Override
    // public ExportResult export(ExportRequest req) {
    //     if (req.body != null && req.body.length() > 20) {
    //         return ExportResult.error("PDF cannot handle content > 20 chars");
    //     }
    //     String fakePdf = "PDF(" + req.title + "):" + req.body;
    //     return new ExportResult("application/pdf", fakePdf.getBytes(StandardCharsets.UTF_8));
    // }

    @Override
    protected String isValid(ExportRequest req) {
        if (req.body != null && req.body.length() > 20) {
            return "PDF cannot handle content > 20 chars";
        }
        return "";
    }

    @Override
    public String getContentType() {
        return "application/pdf";
    }

    @Override
    public String getEncodedContent(ExportRequest normReq) {
        return "PDF(" + normReq.title + "):" + normReq.body;
    }
}
