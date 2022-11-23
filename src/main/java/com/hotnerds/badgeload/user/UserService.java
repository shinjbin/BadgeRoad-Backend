package com.hotnerds.badgeload.user;

import com.hotnerds.badgeload.badge.Badge;
import com.hotnerds.badgeload.badge.BadgeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    PasswordEncoder passwordEncoder;

    public User create(String email, String password, String name) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        this.userRepository.save(user);
        return user;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
