package kr.pbs.babycare.server.api.join;

import com.fasterxml.jackson.annotation.JsonFormat;
import kr.pbs.babycare.server.api.Result;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum JoinResult implements Result {
    FAIL_EXISTS_EMAIL("FP001", "이미 등록된 이메일입니다.")
    ;

    private String code;
    private String message;
}
