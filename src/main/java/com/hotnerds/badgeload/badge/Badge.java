package com.hotnerds.badgeload.badge;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
@Entity(name = "badges")
public class Badge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false)
    String title;

    @Column(nullable = false)
    int category_id;

    @Builder
    public Badge(String title, int category_id) {
        this.title = title;
        this.category_id = category_id;
    }
}
