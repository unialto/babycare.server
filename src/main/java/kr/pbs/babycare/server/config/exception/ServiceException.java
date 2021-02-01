package kr.pbs.babycare.server.config.exception;

import kr.pbs.babycare.server.dto.Results;
import lombok.Getter;

@Getter
public class ServiceException extends RuntimeException {
    private Results result;

    public ServiceException (Results result) {
        super(result.getCode() + " : " + result.getMessage());

        this.result = result;
    }
}
