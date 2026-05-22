package com.practice.xclonecoding.account.dto.request;

import com.practice.xclonecoding.account.domain.Account;
import lombok.*;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CreateAccountRequest {

    private String nickname;
    private String profileImage;
    private Long follower;
    private Long following;

    public Account toEntity() {
        return Account.builder()
                .nickname(nickname)
                .profileImage(profileImage)
                .follower(follower)
                .following(following)
                .build();
    }
}
