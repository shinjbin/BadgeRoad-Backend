package com.hotnerds.badgeload.user;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
@Entity
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 15, nullable = false, unique = true)
    private String email;

    @Column(length = 15, nullable = false)
    private String password;

    @Column(length = 10, nullable = false)
    private String name;

    @Column(length = 10, nullable = false)
    private String nickname;

    @Column(columnDefinition = "VARCHAR(20) default '일반 사용자'") // TODO: ENUM?
    private String role;

    @Column(length = 50)
    private String location;

    @Column
    private Date birthday;

    @Column(columnDefinition = "INT default 1")
    private int level;

    @Builder
    public User(String email,
                String name,
                String password,
                String nickname,
                String role,
                String location,
                Date birthday,
                int level) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.nickname = nickname;
        this.role = role;
        this.location = location;
        this.birthday = birthday;
        this.level = level;
    }
}
