public class JsonExporter extends Exporter {
    // @Override
    // public ExportResult export(ExportRequest req) {
    //     String json = "{\"title\":\"" + escape(req.title) + "\",\"body\":\"" + escape(req.body) + "\"}";
    //     return new ExportResult("application/json", json.getBytes(StandardCharsets.UTF_8));
    // }

    @Override
    protected ExportRequest getNormalizeReq(ExportRequest req) {
        return new ExportRequest(
            escape(req.title),
            escape(req.body)
        );
    }

    @Override
    public String getContentType() {
        return "application/json";
    }

    @Override
    public String getEncodedContent(ExportRequest normReq) {
        return "{\"title\":\"" + normReq.title + "\",\"body\":\"" + normReq.body + "\"}";
    }

    private String escape(String s) {
        if (s == null) return "";
        return s.replace("\"", "\\\"");
    }
}
