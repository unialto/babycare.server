package kr.pbs.babycare.server.dto;

public interface Results {
    public String getCode();

    public String getMessage();

    default Object getData() {
        return null;
    }
}
