package kr.pbs.babycare.server.service;

import kr.pbs.babycare.server.config.exception.ServiceException;
import kr.pbs.babycare.server.dto.ParentResult;
import kr.pbs.babycare.server.entity.Parent;
import kr.pbs.babycare.server.entity.code.ParentState;
import kr.pbs.babycare.server.repository.ParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class JoinService {
    @Autowired
    private ParentRepository parentRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public void join(Parent parent) {
        /*
        같은 이메일이 있으면 예외
         */
        parentRepository.findByEmailAndStateNot(parent.getEmail(), ParentState.W)
                .ifPresent(p -> {
                    throw new ServiceException(ParentResult.FAIL_EXISTS_EMAIL);
                });

        /*
        등록
         */
        parent.setPassword(passwordEncoder.encode(parent.getPassword()));

        parentRepository.save(parent);
    }
}
