package kr.pbs.babycare.server.api.child;

import kr.pbs.babycare.server.api.Result;
import kr.pbs.babycare.server.api.SimpleResult;
import kr.pbs.babycare.server.security.UserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/child")
@RequiredArgsConstructor
public class ChildController {
    private final ChildService childService;

    @GetMapping("/list")
    public Result children(@AuthenticationPrincipal UserDetails userDetails) {
        List<ChildDTO> data = childService.getChildren(userDetails.getIdx());

        return SimpleResult.SUCC.setData(data);
    }
}
