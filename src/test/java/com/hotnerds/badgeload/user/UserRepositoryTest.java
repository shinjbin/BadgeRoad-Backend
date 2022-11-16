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
        final User user = User.builder()
                .email("test@test.com")
                .name("테스트")
                .password("12345678")
                .nickname("테스트닉네임")
                .location("서울")
                .birthday(Date.valueOf("1998-12-29"))
                .build();
        userRepository.save(user);

        List<User> userList = userRepository.findAll();

        User testUser = userList.get(0);
        assertEquals(testUser.getEmail(), "test@test.com");
        assertEquals(testUser.getPassword(), "12345678");
        assertEquals(testUser.getName(), "테스트");
        assertEquals(testUser.getNickname(), "테스트닉네임");
//        assertEquals(testUser.getRole(), "일반 사용자");
    }

    @After
    public void deleteAll() {
        userRepository.deleteAll();
    }
}