package kr.pbs.babycare.server.api.join;

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
        JoinDTO dto = JoinDTO.builder()
                .email("unialto@nate.com")
                .password("babycare")
                .name("베게")
                .build();

        joinService.join(dto);

        System.out.println(dto);

        assertNotEquals(dto.getIdx(), 0);
    }
}