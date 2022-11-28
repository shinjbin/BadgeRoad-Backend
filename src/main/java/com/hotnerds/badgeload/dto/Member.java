package com.hotnerds.badgeload.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@RequiredArgsConstructor
public class Member {
    private Long id;
    private String name;
    private String password;
    private String email;
    private Date createDate = new Date();
    private Date modifyDate = new Date();
}
