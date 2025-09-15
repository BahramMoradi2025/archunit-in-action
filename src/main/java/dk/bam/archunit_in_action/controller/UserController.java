package dk.bam.archunit_in_action.controller;

import dk.bam.archunit_in_action.repository.UserRepository;
import dk.bam.archunit_in_action.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(final UserService userService) {
        this.userService = userService;
    }
}
