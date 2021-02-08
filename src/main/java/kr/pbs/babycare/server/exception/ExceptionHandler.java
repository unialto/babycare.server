package kr.pbs.babycare.server.exception;

import kr.pbs.babycare.server.api.SimpleResult;
import kr.pbs.babycare.server.api.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(ServiceException.class)
    public @ResponseBody
    Result handleServiceException(HttpServletRequest request, ServiceException e) {
        return e.getResult();
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public @ResponseBody
    Result handleException(HttpServletRequest request, Exception e) {
        return SimpleResult.FAIL;
    }
}
