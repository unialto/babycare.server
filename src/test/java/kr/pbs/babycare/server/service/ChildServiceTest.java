package kr.pbs.babycare.server.service;

import kr.pbs.babycare.server.entity.Child;
import kr.pbs.babycare.server.entity.Parent;
import kr.pbs.babycare.server.entity.code.Gender;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
class ChildServiceTest {
    @Autowired
    private ChildService childService;

    @Test
    void addChild() {
        Child child = Child.builder()
                .parent(Parent.builder().idx(47).build())
                .name("친구2")
                .birthday(LocalDate.now().minus(2, ChronoUnit.YEARS))
                .gender(Gender.F)
                .build();

        childService.addChild(child);

        System.out.println(child);

        assertNotEquals(child.getIdx(), 0);
    }
}