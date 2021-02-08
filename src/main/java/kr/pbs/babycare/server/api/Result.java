package kr.pbs.babycare.server.api;

public interface Result {
    public String getCode();

    public String getMessage();

    default Object getData() {
        return null;
    }
}
