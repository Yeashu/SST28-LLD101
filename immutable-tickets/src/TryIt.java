import com.example.tickets.IncidentTicket;
import com.example.tickets.TicketService;

import java.util.List;

public class TryIt {

    public static void main(String[] args) {
        TicketService service = new TicketService();

        IncidentTicket original = service.createTicket(
                "TCK-1001", "reporter@example.com", "Payment failing on checkout");
        System.out.println("original  : " + original);

        IncidentTicket assigned  = service.assign(original, "agent@example.com");
        IncidentTicket escalated = service.escalateToCritical(assigned);

        System.out.println("\nassigned  : " + assigned);
        System.out.println("escalated : " + escalated);
        System.out.println("\noriginal (unchanged): " + original);

        System.out.println("\noriginal == assigned?  " + (original == assigned));
        System.out.println("original == escalated? " + (original == escalated));

        List<String> tags = original.getTags();
        System.out.println("\nAttempting external tag mutation on original...");
        try {
            tags.add("HACKED_FROM_OUTSIDE");
            System.out.println("ERROR: mutation succeeded — this should not happen!");
        } catch (UnsupportedOperationException e) {
            System.out.println("Correctly blocked: UnsupportedOperationException thrown.");
            System.out.println("original tags still: " + original.getTags());
        }

        IncidentTicket custom = new IncidentTicket.Builder(
                    "TCK-9999", "ops@example.com", "Database connection pool exhausted")
                .priority("HIGH")
                .source("WEBHOOK")
                .slaMinutes(60)
                .addTag("DB")
                .addTag("PROD")
                .customerVisible(true)
                .build();
        System.out.println("\ncustom    : " + custom);
    }
}
