package com.hotnerds.badgeload.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class MemberRole {
    private Long id;
    private Long memberId;
    private String roleName;
}
