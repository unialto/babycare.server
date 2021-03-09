package kr.pbs.babycare.server.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.pbs.babycare.server.entity.Parent;
import kr.pbs.babycare.server.entity.QParent;
import kr.pbs.babycare.server.entity.code.ParentState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest //@Transactional 포함
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) //실제 DB 사용
class ParentRepositoryTest {
    @PersistenceContext
    private EntityManager entityManager;
    private JPAQueryFactory queryFactory;

    @Autowired
    private ParentRepository parentRepository;

    @BeforeEach
    public void init() {
        this.queryFactory = new JPAQueryFactory(entityManager);
    }

    @Test
    void findByEmailAndStateNot() {
        /*
        Parent parent = Parent.builder()
                .email("unialto@nate.com")
                .build();

        Parent p = parentRepository.findByEmailAndStateNot(parent.getEmail(), ParentState.W).orElse(null);
        */

        //JPA + QueryDSL
        /*
        QParent qParent = QParent.parent;

        Parent p = parentRepository.findOne(
                qParent.email.eq("unialto@nate.com")
                .and(qParent.state.ne(ParentState.W))
        ).orElse(null);
        */

        //QueryDSL
        QParent qParent = QParent.parent;

        Parent p = queryFactory.selectFrom(qParent).where(
                qParent.email.eq("unialto@nate.com")
                .and(qParent.state.ne(ParentState.W))
        ).fetchOne();

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