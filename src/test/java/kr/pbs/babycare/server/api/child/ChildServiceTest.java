package kr.pbs.babycare.server.api.child;

import kr.pbs.babycare.server.entity.code.Gender;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
class ChildServiceTest {
    @Autowired
    private ChildService childService;

    @Test
    void addChild() {
        ChildDTO dto = ChildDTO.builder()
                .parentIdx(48)
                .name("친구5")
                .birthday(LocalDate.now().minus(2, ChronoUnit.YEARS))
                .gender(Gender.F)
                .build();

        childService.addChild(dto);

        System.out.println(dto);

        assertNotEquals(dto.getIdx(), 0);
    }

    @Test
    void getChildren() {
        int parentIdx = 48;

        List<ChildDTO> result = childService.getChildren(parentIdx);

        System.out.println(result);

        result.stream().forEach(c -> assertEquals(c.getParentIdx(), parentIdx));
    }
}