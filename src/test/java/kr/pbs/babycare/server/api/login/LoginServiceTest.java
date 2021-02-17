package kr.pbs.babycare.server.api.login;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class LoginServiceTest {
    @Autowired
    private LoginService loginService;

    @Test
    void login() {
        LoginDTO dto = LoginDTO.builder()
                .email("unialto2@nate.com")
                .password("babycare")
                .build();

        LoginDTO result = loginService.login(dto);

        System.out.println(result);

        assertNotNull(result);
    }
}