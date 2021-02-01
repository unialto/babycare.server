package kr.pbs.babycare.server.entity.code;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Gender {
    M("남자"),
    F("여자")
    ;

    private String comment;
}
