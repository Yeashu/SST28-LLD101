public class WhatsAppSender extends NotificationSender {
    public WhatsAppSender(AuditLog audit) { super(audit); }

    @Override
    protected String isValid(Notification n) {
        if (n.phone == null || !n.phone.startsWith("+")) {
            // add to audit and return error message
            super.audit.add("WA failed");
            return "WA ERROR: " + "phone must start with + and country code";
        }
        return "";
    }

    @Override
    public void doSend(Notification n) {
        System.out.println("WA -> to=" + n.phone + " body=" + n.body);
        audit.add("wa sent");
    }
}
