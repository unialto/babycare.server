package kr.pbs.babycare.server.api;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum SimpleResult implements Result {
    SUCC("S", "성공했습니다."),
    FAIL("F", "실패했습니다."),
    ;

    private final String code;
    private final String message;
    private Object data;

    public SimpleResult setData(Object data) {
        this.data = data;
        return this;
    }
}
