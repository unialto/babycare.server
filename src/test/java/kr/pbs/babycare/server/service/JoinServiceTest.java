package kr.pbs.babycare.server.service;

import kr.pbs.babycare.server.entity.Parent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
class JoinServiceTest {
    @Autowired
    private JoinService joinService;

    @Test
    void join() {
        Parent parent = Parent.builder()
                .email("unialto@nate.com")
                .password("babycare")
                .name("베게")
                .build();

        joinService.join(parent);

        System.out.println(parent);

        assertNotEquals(parent.getIdx(), 0);
    }
}