package kr.pbs.babycare.server.service;

import kr.pbs.babycare.server.entity.Parent;
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
        Parent parent = Parent.builder()
                .email("unialto@nate.com")
                .password("babycare")
                .build();

        Parent p = loginService.login(parent);

        System.out.println(p);

        assertNotNull(p);
    }
}