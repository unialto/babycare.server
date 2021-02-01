package kr.pbs.babycare.server.repository;

import kr.pbs.babycare.server.entity.Parent;
import kr.pbs.babycare.server.entity.code.ParentState;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest //@Transactional 포함
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) //실제 DB 사용
class ParentRepositoryTest {
    @Autowired
    private ParentRepository parentRepository;

    @Test
    void findByEmailAndStateNot() {
        Parent parent = Parent.builder()
                .email("unialto@nate.com")
                .build();

        Parent p = parentRepository.findByEmailAndStateNot(parent.getEmail(), ParentState.W).orElse(null);

        System.out.println(p);

        assertNotNull(p);
    }

    @Test
    @Rollback(value = false) //테스트 후 롤백하지 않게
    void save() {
        Parent parent = Parent.builder()
                .email("unialto@nate.com")
                .password("babycare")
                .name("베게")
                .build();

        parentRepository.save(parent);

        System.out.println(parent);

        assertNotEquals(parent.getIdx(), 0);
    }
}