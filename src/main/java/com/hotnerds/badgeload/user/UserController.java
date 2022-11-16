package com.hotnerds.badgeload.user;

import com.hotnerds.badgeload.badge.Badge;
import com.hotnerds.badgeload.badge.BadgeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class UserController {
    private final UserRepository userRepository;

    @GetMapping("user")
    public List<User> findAllBadges() {
        return userRepository.findAll();
    }

    @PostMapping("user/signup")
    public User signUp() {
        final User user = User.builder()
                .email("test@test.com")
                .name("shin")
                .password("1234")
                .role("일반 사용자")
                .location("서울")
                .birthday(Date.valueOf("1998-12-29"))
                .level(1)
                .build();
        return userRepository.save(user);
    }

}


