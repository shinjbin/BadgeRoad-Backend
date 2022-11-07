package com.hotnerds.badgeload.badge;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
@Entity
public class Badge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20)
    String title;

    @Column(length = 20)
    String category;

    @Builder
    public Badge(String title, String category) {
        this.title = title;
        this.category = category;
    }
}
