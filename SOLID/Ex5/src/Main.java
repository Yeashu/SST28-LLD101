public class Main {
    public static void main(String[] args) {
        System.out.println("=== Export Demo ===");

        ExportRequest req = new ExportRequest("Weekly Report", SampleData.longBody());
        Exporter pdf = new PdfExporter();
        Exporter csv = new CsvExporter();
        Exporter json = new JsonExporter();

        System.out.println("PDF: " + safePrint(pdf, req));
        System.out.println("CSV: " + safePrint(csv, req));
        System.out.println("JSON: " + safePrint(json, req));
    }

    private static String safePrint(Exporter e, ExportRequest r) {
        ExportResult out = e.export(r);
        if (out.isError()) return "ERROR: " + out.error;
        return "OK bytes=" + out.bytes.length;
    }
}
