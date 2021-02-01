package kr.pbs.babycare.server.controller;

import kr.pbs.babycare.server.dto.Result;
import kr.pbs.babycare.server.dto.Results;
import kr.pbs.babycare.server.entity.Parent;
import kr.pbs.babycare.server.service.JoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/join")
public class JoinController {
    @Autowired
    private JoinService joinService;

    @PostMapping
    public Results join(Parent parent) {
        joinService.join(parent);

        return Result.SUCC;
    }
}
