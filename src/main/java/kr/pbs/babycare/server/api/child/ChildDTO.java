package kr.pbs.babycare.server.api.child;

import com.fasterxml.jackson.annotation.JsonFormat;
import kr.pbs.babycare.server.entity.code.ChildState;
import kr.pbs.babycare.server.entity.code.Gender;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder
@Data
public class ChildDTO {
    private int idx;

    private String name;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    private Gender gender;

    private ChildState state;

    private int parentIdx;
}
