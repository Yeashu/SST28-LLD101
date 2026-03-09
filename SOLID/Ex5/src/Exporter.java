import java.nio.charset.StandardCharsets;

public abstract class Exporter {

    public final ExportResult export(ExportRequest req){
        String err = isValid(req);
        if (!err.isEmpty()) {
            return ExportResult.error(err);
        }
        ExportRequest norm = getNormalizeReq(req);
        String contentType = getContentType();
        String encodedContent = getEncodedContent(norm);
        return new ExportResult(contentType, encodedContent.getBytes(StandardCharsets.UTF_8));
    }

    // empty string means valid, otherwise error message
    protected String isValid(ExportRequest req) {
        return "";
    }
    protected ExportRequest getNormalizeReq(ExportRequest req) {
        return req;
    }
    public abstract String getContentType();
    public abstract String getEncodedContent(ExportRequest normReq);
}
