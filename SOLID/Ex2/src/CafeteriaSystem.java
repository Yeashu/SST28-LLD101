import java.util.*;

public class CafeteriaSystem {
    private final Map<String, MenuItem> menu = new LinkedHashMap<>();
    private final DatabaseStore store;
    private int invoiceSeq = 1000;
    public CafeteriaSystem(DatabaseStore store) { this.store = store; }
    public void addToMenu(MenuItem i) { menu.put(i.id, i); }

    // Intentionally SRP-violating: menu mgmt + tax + discount + format + persistence.
    public void checkout(String customerType, List<OrderLine> lines) {

        double subtotal = util.getSubtotal(lines, menu);
        double tax = util.getTax(customerType, subtotal);
        double discount = util.getDiscount(customerType, subtotal, lines.size());
        
        double total = subtotal + tax - discount;

        String invId = "INV-" + ++invoiceSeq;
        String printable =InvoiceFormatter.printInvoice(customerType, subtotal, tax, discount, total, invId);

        store.save(invId, printable);
        System.out.println("Saved invoice: " + invId + " (lines=" + store.countLines(invId) + ")");

    }
}
