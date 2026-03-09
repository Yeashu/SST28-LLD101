public abstract class NotificationSender {
    protected final AuditLog audit;
    protected NotificationSender(AuditLog audit) { this.audit = audit; }
    public SendResult send(Notification n){
        String err = isValid(n);
        if (!err.isEmpty()) {
            return SendResult.error(err);
        }
        Notification sendable = getSendableNotification(n);
        doSend(sendable);
        return SendResult.ok();
    }
    protected String isValid(Notification n) {
        return ""; // empty string means valid, otherwise error message
    }
    protected Notification getSendableNotification(Notification n) {
        return n;
    }
    protected abstract void doSend(Notification SendableNotification);
}
