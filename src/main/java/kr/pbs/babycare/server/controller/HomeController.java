package kr.pbs.babycare.server.controller;

import kr.pbs.babycare.server.dto.Result;
import kr.pbs.babycare.server.dto.Results;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {
    @GetMapping("/{parentIdx}")
    public EntityModel<Results> home(@PathVariable("parentIdx") int parentIdx) {
        return EntityModel.of((Results)Result.SUCC)
                .add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ChildController.class).children(parentIdx)).withRel("children"));
    }
}
