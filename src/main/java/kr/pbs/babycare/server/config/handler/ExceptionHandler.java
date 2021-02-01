package kr.pbs.babycare.server.config.handler;

import kr.pbs.babycare.server.config.exception.ServiceException;
import kr.pbs.babycare.server.dto.Result;
import kr.pbs.babycare.server.dto.Results;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(ServiceException.class)
    public @ResponseBody
    Results handleServiceException(HttpServletRequest request, ServiceException e) {
        return e.getResult();
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public @ResponseBody
    Results handleException(HttpServletRequest request, Exception e) {
        return Result.FAIL;
    }
}
