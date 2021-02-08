package kr.pbs.babycare.server.api.login;

import kr.pbs.babycare.server.api.Result;
import kr.pbs.babycare.server.api.SimpleResult;
import kr.pbs.babycare.server.security.SecurityService;
import kr.pbs.babycare.server.security.UserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {
    private final LoginService loginService;
    private final SecurityService securityService;

    @PostMapping
    public Result login(LoginDTO dto) {
        LoginDTO result = loginService.login(dto);

        String token = securityService.createToken(
                UserDetails.builder()
                        .idx(result.getIdx())
                        .username(result.getEmail())
                        .password(result.getPassword())
                        .roles(Collections.singletonList("ROLE_USER"))
                        .build()
        );

        return SimpleResult.SUCC.setData(token);
    }
}
