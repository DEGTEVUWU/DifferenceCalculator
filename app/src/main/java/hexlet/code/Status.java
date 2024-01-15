package hexlet.code;

public class Status {
    private final String value;
    private final String status;

    public Status(String value, String status) {
        this.value = value;
        this.status = status;
    }

    public String getValue() {
        return value;
    }

    public String isStatus() {
        return status;
    }
}
