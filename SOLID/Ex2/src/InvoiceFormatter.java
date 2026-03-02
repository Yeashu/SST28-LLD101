import java.util.List;

public class InvoiceFormatter {
    public static String printInvoice(String invId,
                                      List<InvoiceLine> invoiceLines,
                                      double subtotal,
                                      double taxPercent,
                                      double tax,
                                      double discount,
                                      double total) {
        StringBuilder out = new StringBuilder();
        out.append("Invoice# ").append(invId).append("\n");

        for (InvoiceLine line : invoiceLines) {
            out.append(String.format("- %s x%d = %.2f\n", line.itemName, line.qty, line.lineTotal));
        }

        out.append(String.format("Subtotal: %.2f\n", subtotal));
        out.append(String.format("Tax(%.0f%%): %.2f\n", taxPercent, tax));
        out.append(String.format("Discount: -%.2f\n", discount));
        out.append(String.format("TOTAL: %.2f", total));

        String printable = out.toString();
        System.out.println(printable);
        return printable;
    }
}
