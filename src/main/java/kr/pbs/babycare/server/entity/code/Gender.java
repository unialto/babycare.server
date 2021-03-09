package kr.pbs.babycare.server.entity.code;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Gender {
    M("남자"),
    F("여자")
    ;

    private final String comment;
}
