package kr.pbs.babycare.server.entity.code;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ParentState {
    A("활동"),
    W("탈퇴"),
    L("잠김"),
    D("휴면")
    ;

    private final String comment;
}
