package com.hotnerds.badgeload.badge;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BadgeRepositoryTest {

    @Autowired
    BadgeRepository badgeRepository;

    @Test
    public void 뱃지저장_불러오기() {
        Badge badge = Badge.builder()
                .title("테스트 뱃지")
                .category_id(123)
                .build();
        badgeRepository.save(badge);

        List<Badge> badgeList = badgeRepository.findAll();

        Badge testBadge = badgeList.get(0);
        assertEquals(testBadge.getTitle(), "테스트 뱃지");
        assertEquals(testBadge.getCategory_id(), 123);
    }

    @After
    public void deleteAll() {
        badgeRepository.deleteAll();
    }
}