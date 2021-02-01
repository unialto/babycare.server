package kr.pbs.babycare.server.service;

import kr.pbs.babycare.server.config.exception.ServiceException;
import kr.pbs.babycare.server.dto.ChildResult;
import kr.pbs.babycare.server.entity.Child;
import kr.pbs.babycare.server.entity.Parent;
import kr.pbs.babycare.server.entity.code.ChildState;
import kr.pbs.babycare.server.repository.ChildRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ChildService {
    @Autowired
    private ChildRepository childRepository;

    public List<Child> getChildren(int parentIdx) {
        return childRepository.findByParentAndStateNot(Parent.builder().idx(parentIdx).build(), ChildState.D);
    }

    @Transactional
    public void addChild(Child child) {
        /*
        같은 이름이 있으면 예외
         */
        childRepository.findByParentAndNameAndStateNot(child.getParent(), child.getName(), ChildState.D)
                .ifPresent(c -> {
                    throw new ServiceException(ChildResult.FAIL_EXISTS_NAME);
                });

        /*
        등록
         */
        childRepository.save(child);
    }
}
