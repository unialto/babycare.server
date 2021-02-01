package kr.pbs.babycare.server.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Result implements Results {
    SUCC("S", "성공했습니다."),
    FAIL("F", "실패했습니다."),
    ;

    @NonNull private String code;
    @NonNull private String message;
    private Object data;

    public Result setData(Object data) {
        this.data = data;
        return this;
    }
}
