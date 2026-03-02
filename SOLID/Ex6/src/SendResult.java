public class SendResult {
    public final String error; // null means success

    private SendResult(String error) { this.error = error; }

    public static SendResult ok() { return new SendResult(null); }
    public static SendResult error(String msg) { return new SendResult(msg); }
    public boolean isError() { return error != null; }
}
