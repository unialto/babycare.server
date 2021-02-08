package kr.pbs.babycare.server.api.join;

import kr.pbs.babycare.server.api.Result;
import kr.pbs.babycare.server.api.SimpleResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/join")
@RequiredArgsConstructor
public class JoinController {
    private final JoinService joinService;

    @PostMapping
    public Result join(JoinDTO dto) {
        joinService.join(dto);

        return SimpleResult.SUCC;
    }
}
