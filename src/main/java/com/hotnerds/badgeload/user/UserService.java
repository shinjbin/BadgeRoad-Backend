package com.hotnerds.badgeload.user;

import com.hotnerds.badgeload.badge.Badge;
import com.hotnerds.badgeload.badge.BadgeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User getSelectOne(User user) throws Exception{
        return userRepository.getSelectOne(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
