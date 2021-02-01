package kr.pbs.babycare.server.entity.code;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ParentState {
    A("활동"),
    W("탈퇴"),
    L("잠김"),
    D("휴면")
    ;

    private String comment;
}
