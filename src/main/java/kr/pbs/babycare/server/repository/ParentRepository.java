package kr.pbs.babycare.server.repository;

import kr.pbs.babycare.server.entity.Parent;
import kr.pbs.babycare.server.entity.code.ParentState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ParentRepository extends JpaRepository<Parent, Integer>, QuerydslPredicateExecutor<Parent> {
    Optional<Parent> findByEmailAndStateNot(String email, ParentState state);
}
