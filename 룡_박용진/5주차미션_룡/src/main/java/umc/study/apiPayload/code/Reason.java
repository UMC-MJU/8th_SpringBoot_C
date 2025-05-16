package umc.study.apiPayload.code;

public class Reason {
    private final String message;
    private final int status;

    public Reason(String message, int status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }
}
