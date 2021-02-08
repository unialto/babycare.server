package kr.pbs.babycare.server.api.login;

import kr.pbs.babycare.server.entity.Parent;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class LoginDTO extends Parent {
    private String token;
}
