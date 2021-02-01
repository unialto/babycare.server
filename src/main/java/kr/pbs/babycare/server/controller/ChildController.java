package kr.pbs.babycare.server.controller;

import kr.pbs.babycare.server.dto.Result;
import kr.pbs.babycare.server.dto.Results;
import kr.pbs.babycare.server.entity.Child;
import kr.pbs.babycare.server.service.ChildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/child")
public class ChildController {
    @Autowired
    private ChildService childService;

    @GetMapping("/list/{parentIdx}")
    public Results children(@PathVariable(value = "parentIdx") int parentIdx) {
        List<Child> children = childService.getChildren(parentIdx);

        return Result.SUCC.setData(children);
    }
}
