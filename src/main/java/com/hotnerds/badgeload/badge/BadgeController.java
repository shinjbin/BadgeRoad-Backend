package com.hotnerds.badgeload.badge;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1")
public class BadgeController {
    private final BadgeRepository badgeRepository;

    @GetMapping("badges")
    public List<Badge> findAllBadges() {
        return badgeRepository.findAll();
    }

    @PostMapping("badges")
    public Badge addBadge() {
        final Badge badge = Badge.builder()
                .title("test_title")
                .category_id(123)
                .build();
        return badgeRepository.save(badge);
    }
}
