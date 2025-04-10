package study.ratelsproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import study.ratelsproject.domain.User;
import study.ratelsproject.service.UserService;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/test_selectByUserId")
    public User test() throws ClassNotFoundException {
        User user = userService.getUserById(1);
        return user;
    }
}
