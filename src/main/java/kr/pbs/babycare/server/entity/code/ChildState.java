package kr.pbs.babycare.server.entity.code;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ChildState {
    A("활동"),
    D("삭제")
    ;

    private final String comment;
}
