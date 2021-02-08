package kr.pbs.babycare.server.api.login;

import com.fasterxml.jackson.annotation.JsonFormat;
import kr.pbs.babycare.server.api.Result;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum LoginResult implements Result {
    FAIL_NOT_EXISTS("FP002", "등록되지 않은 회원입니다."),
    FAIL_PASSWORD("FP003", "비밀번호가 틀렸습니다."),
    FAIL_LOCK("FP004", "정지회원입니다."),
    FAIL_DORMANT("FP005", "휴면회원입니다.")
    ;

    private String code;
    private String message;
}
