package kr.pbs.babycare.server.api.child;

import kr.pbs.babycare.server.entity.Child;
import kr.pbs.babycare.server.entity.Parent;
import kr.pbs.babycare.server.entity.code.ChildState;
import kr.pbs.babycare.server.exception.ServiceException;
import kr.pbs.babycare.server.repository.ChildRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ChildService {
    private final ChildRepository childRepository;

    public List<ChildDTO> getChildren(int parentIdx) {
        List<Child> children = childRepository.findByParentAndStateNot(Parent.builder().idx(parentIdx).build(), ChildState.D);

        return children.stream()
                .map(ChildMapper.MAPPER::toChildDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public void addChild(ChildDTO dto) {
        Child child = ChildMapper.MAPPER.toChild(dto);

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

        dto.setIdx(child.getIdx());
    }
}
