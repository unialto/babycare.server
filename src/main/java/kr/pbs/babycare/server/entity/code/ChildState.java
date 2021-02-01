package kr.pbs.babycare.server.entity.code;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ChildState {
    A("활동"),
    D("삭제")
    ;

    private String comment;
}
