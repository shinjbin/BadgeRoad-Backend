package com.hotnerds.badgeload.user;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 15, nullable = false, unique = true)
    private String user_id;

    @Column(length = 5, nullable = false)
    private String user_name;

    @Column(length = 15, nullable = false)
    private String user_password;

    @Column(length = 20, nullable = false) // TODO: ENUM?
    private String user_role;

    @Column(length = 50)
    private String user_location;

    @Column(name = "DATE_FIELD")
    private Date user_birthday;

    @Column(length = 3, nullable = false)
    private int user_level;

    @Builder
    public User(String user_id,
                String user_name,
                String user_password,
                String user_role,
                String user_location,
                Date user_birthday,
                int user_level) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_password = user_password;
        this.user_role = user_role;
        this.user_location = user_location;
        this.user_birthday = user_birthday;
        this.user_level = user_level;
    }
}
