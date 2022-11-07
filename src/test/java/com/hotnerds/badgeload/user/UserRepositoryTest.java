package com.hotnerds.badgeload.user;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void 유저저장_불러오기() {
        User user = User.builder().
                user_id("abc123")
                .user_name("홍길동")
                .user_password("12345678")
                .user_role("인플루언서")
                .user_location("서울특별시")
                .user_birthday(Date.valueOf(LocalDate.of(1998, 12, 29)))
                .user_level(5)
                .build();
        userRepository.save(user);

        List<User> userList = userRepository.findAll();

        User testUser = userList.get(0);
        assertEquals(testUser.getUser_id(), "abc123");
        assertEquals(testUser.getUser_password(), "12345678");
        assertEquals(testUser.getUser_name(), "홍길동");
    }

    @After
    public void deleteAll() {
        userRepository.deleteAll();
    }
}