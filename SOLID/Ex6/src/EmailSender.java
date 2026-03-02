public class EmailSender extends NotificationSender {
    public EmailSender(AuditLog audit) { super(audit); }

    @Override
    public SendResult send(Notification n) {
        String body = n.body;
        if (body.length() > 40){
            return SendResult.error("email body must be <= 40 chars");
        };
        System.out.println("EMAIL -> to=" + n.email + " subject=" + n.subject + " body=" + body);
        audit.add("email sent");
        return SendResult.ok();
    }
}
