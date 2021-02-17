package kr.pbs.babycare.server.api.login;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class LoginDTO {
    private int idx;

    private String email;

    private String password;

    private String token;
}
