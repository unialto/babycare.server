package kr.pbs.babycare.server.api.child;

import kr.pbs.babycare.server.entity.Child;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class ChildDTO extends Child {
    private int parentIdx;
}
