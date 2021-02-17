package kr.pbs.babycare.server.api.login;

import kr.pbs.babycare.server.entity.Parent;
import kr.pbs.babycare.server.entity.code.ParentState;
import kr.pbs.babycare.server.exception.ServiceException;
import kr.pbs.babycare.server.repository.ParentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class LoginService {
    private final ParentRepository parentRepository;

    private final PasswordEncoder passwordEncoder;

    public LoginDTO login(LoginDTO dto) {
        Parent parent = parentRepository.findByEmailAndStateNot(dto.getEmail(), ParentState.W)
                .orElseThrow(() -> new ServiceException((LoginResult.FAIL_NOT_EXISTS)));

        if (!passwordEncoder.matches(dto.getPassword(), parent.getPassword())) {
            throw new ServiceException(LoginResult.FAIL_PASSWORD);
        }

        if (ParentState.L == parent.getState()) {
            throw new ServiceException(LoginResult.FAIL_LOCK);
        }

        if (ParentState.D == parent.getState()) {
            throw new ServiceException(LoginResult.FAIL_DORMANT);
        }

        return LoginMapper.MAPPER.toLoginDTO(parent);
    }
}
