package com.hotnerds.badgeload.user;

import com.hotnerds.badgeload.badge.Badge;
import com.hotnerds.badgeload.badge.BadgeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class UserController {
    private final UserRepository userRepository;
    private final UserService userService;

    @GetMapping("/user")
    public List<User> findAllBadges() {
        return userRepository.findAll();
    }

    @PostMapping("/user")
    public User newUser(@RequestBody User newUser) {
        return userRepository.save(newUser);
    }

    @GetMapping("/user/login")
    public String login() {
        return "login";
    }

    @PostMapping("user/signup")
    public String signUp(@Valid UserCreateForm userCreateForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "signup_form";
        }

        if (!userCreateForm.getPassword1().equals(userCreateForm.getPassword2())) {
            bindingResult.rejectValue("password2", "passwordIncorrect",
                    "2개의 패스워드가 일치하지 않습니다.");
            return "signup_form";
        }

        userService.create(userCreateForm.getEmail(), userCreateForm.getPassword1(), userCreateForm.getName());

        return "redirect:/";
    }

}


