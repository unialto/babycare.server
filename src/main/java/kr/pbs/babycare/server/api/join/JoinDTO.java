package kr.pbs.babycare.server.api.join;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class JoinDTO {
    private String email;

    private String password;

    private String name;
}
