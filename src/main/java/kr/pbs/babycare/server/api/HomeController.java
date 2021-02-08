package kr.pbs.babycare.server.api;

import kr.pbs.babycare.server.api.child.ChildController;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
@RequiredArgsConstructor
public class HomeController {
    @GetMapping()
    public EntityModel<Result> home() {
        return EntityModel.of((Result)SimpleResult.SUCC)
                .add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ChildController.class).children(null)).withRel("children"));
    }
}
