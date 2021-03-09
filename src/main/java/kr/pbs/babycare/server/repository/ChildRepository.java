package kr.pbs.babycare.server.repository;

import kr.pbs.babycare.server.entity.Child;
import kr.pbs.babycare.server.entity.Parent;
import kr.pbs.babycare.server.entity.code.ChildState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChildRepository extends JpaRepository<Child, Integer>, QuerydslPredicateExecutor {
    List<Child> findByParentAndStateNot(Parent parent, ChildState state);

    Optional<Child> findByParentAndNameAndStateNot(Parent parent, String name, ChildState state);
}
