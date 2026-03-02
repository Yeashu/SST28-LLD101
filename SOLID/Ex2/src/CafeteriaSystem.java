import java.util.*;

public class CafeteriaSystem {
    private final Map<String, MenuItem> menu = new LinkedHashMap<>();
    private final DatabaseStore store;
    private final TaxPolicy taxPolicy;
    private final DiscountPolicy discountPolicy;
    private int invoiceSeq = 1000;

    public CafeteriaSystem(DatabaseStore store) {
        this(store, new TaxRules(), new DiscountRules());
    }

    public CafeteriaSystem(DatabaseStore store, TaxPolicy taxPolicy, DiscountPolicy discountPolicy) {
        this.store = store;
        this.taxPolicy = taxPolicy;
        this.discountPolicy = discountPolicy;
    }

    public void addToMenu(MenuItem i) { menu.put(i.id, i); }

    public void checkout(String customerType, List<OrderLine> lines) {
        List<InvoiceLine> invoiceLines = new ArrayList<>();
        double subtotal = 0.0;

        for (OrderLine l : lines) {
            MenuItem item = menu.get(l.itemId);
            double lineTotal = util.getLineTotal(item, l.qty);
            subtotal += lineTotal;
            invoiceLines.add(new InvoiceLine(item.name, l.qty, lineTotal));
        }

        double taxPercent = taxPolicy.taxPercent(customerType);
        double tax = util.taxFromPercent(subtotal, taxPercent);
        double discount = discountPolicy.discountAmount(customerType, subtotal, lines.size());
        double total = subtotal + tax - discount;

        String invId = "INV-" + ++invoiceSeq;
        String printable = InvoiceFormatter.printInvoice(invId, invoiceLines, subtotal, taxPercent, tax, discount, total);

        store.save(invId, printable);
        System.out.println("Saved invoice: " + invId + " (lines=" + store.countLines(invId) + ")");
    }
}
