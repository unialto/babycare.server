package kr.pbs.babycare.server.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ChildResult implements Results {
    FAIL_EXISTS_NAME("FC001", "이미 등록된 이름입니다.")
    ;

    private String code;
    private String message;
}
