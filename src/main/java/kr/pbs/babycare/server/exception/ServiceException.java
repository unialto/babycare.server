package kr.pbs.babycare.server.exception;

import kr.pbs.babycare.server.api.Result;
import lombok.Getter;

@Getter
public class ServiceException extends RuntimeException {
    private Result result;

    public ServiceException (Result result) {
        super(result.getCode() + " : " + result.getMessage());

        this.result = result;
    }
}
