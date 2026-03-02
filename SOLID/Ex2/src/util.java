import java.util.List;
import java.util.Map;

public class util {
    public static double getSubtotal(List<OrderLine> lines, Map<String, MenuItem> menu) {
        double subtotal = 0.0;
        for (OrderLine l : lines) {
            MenuItem item = menu.get(l.itemId);
            double lineTotal = item.price * l.qty;
            subtotal += lineTotal;
        }
        return subtotal;
    }

    public static double getLineTotal(MenuItem item, int qty) {
        return item.price * qty;
    }

    public static double taxFromPercent(double subtotal, double taxPercent) {
        return subtotal * (taxPercent / 100.0);
    }
}
