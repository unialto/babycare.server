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
public class LoginService {
    @Autowired
    private ParentRepository parentRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Parent login(Parent parent) {
        Parent p = parentRepository.findByEmailAndStateNot(parent.getEmail(), ParentState.W)
                .orElseThrow(() -> new ServiceException((ParentResult.FAIL_NOT_EXISTS)));

        if (!passwordEncoder.matches(parent.getPassword(), p.getPassword())) {
            throw new ServiceException(ParentResult.FAIL_PASSWORD);
        }

        if (ParentState.L == p.getState()) {
            throw new ServiceException(ParentResult.FAIL_LOCK);
        }

        if (ParentState.D == p.getState()) {
            throw new ServiceException(ParentResult.FAIL_DORMANT);
        }

        return p;
    }
}
