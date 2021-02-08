package kr.pbs.babycare.server.api.join;

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
public class JoinService {
    private final ParentRepository parentRepository;

    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void join(JoinDTO dto) {
        /*
        같은 이메일이 있으면 예외
         */
        parentRepository.findByEmailAndStateNot(dto.getEmail(), ParentState.W)
                .ifPresent(p -> {
                    throw new ServiceException(JoinResult.FAIL_EXISTS_EMAIL);
                });

        /*
        등록
         */
        parentRepository.save(
                Parent.builder()
                        .email(dto.getEmail())
                        .password(passwordEncoder.encode(dto.getPassword()))
                        .name(dto.getName())
                        .build()
        );
    }
}
