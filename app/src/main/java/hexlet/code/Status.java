package hexlet.code;

public final class Status {
    private final Object oldValue;
    private final Object newValue;

    private final String status;

    public Status(Object oldValue, Object newValue, String status) {
        this.oldValue = oldValue;
        this.newValue = newValue;
        this.status = status;
    }

    public Object getOldValue() {
        return oldValue;
    }
    public Object getNewValue() {
        return newValue;
    }

    public String isStatus() {
        return status;
    }
}
