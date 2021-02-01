package kr.pbs.babycare.server.controller;

import kr.pbs.babycare.server.dto.Result;
import kr.pbs.babycare.server.dto.Results;
import kr.pbs.babycare.server.entity.Parent;
import kr.pbs.babycare.server.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping
    public Results login(Parent parent) {
        Parent p = loginService.login(parent);

        return Result.SUCC.setData(p);
    }
}
