public class EmailSender extends NotificationSender {
    public EmailSender(AuditLog audit) { super(audit); }

    @Override
    protected Notification getSendableNotification(Notification n) {
        if (n.body.length() > 40) {
            n = new Notification(n.subject, n.body.substring(0, 40), n.email, n.phone);
        }
        return n;
    }

    @Override
    public void doSend(Notification n) {
        System.out.println("EMAIL -> to=" + n.email + " subject=" + n.subject + " body=" + n.body);
        audit.add("email sent");
    }
}
