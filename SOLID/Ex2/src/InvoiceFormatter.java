public class InvoiceFormatter {
    // now useful wrapper
    public static String identityFormat(String s) { return s; }
    public static String printInvoice(String customerType, double subtotal, double tax, double discount, double total, String invId) {
        StringBuilder out = new StringBuilder();
        out.append("Invoice# ").append(invId).append("\n");

        out.append(String.format("Subtotal: %.2f\n", subtotal));
        out.append(String.format("Tax(%.0f%%): %.2f\n", TaxRules.taxPercent(customerType), tax));
        out.append(String.format("Discount: -%.2f\n", discount));
        out.append(String.format("TOTAL: %.2f\n", total));

        String printable = InvoiceFormatter.identityFormat(out.toString());
        System.out.print(printable);
        return printable;
    }
}
