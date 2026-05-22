package com.practice.xclonecoding.account.dto.response;

import com.practice.xclonecoding.account.domain.Account;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
@AllArgsConstructor
public class AccountResponse {

    private Long accountId;
    private String nickname;
    private String profileImage;
    private Long following;
    private Long follower;
    LocalDateTime createdAt;

    public static AccountResponse from(Account account) {
        return AccountResponse.builder()
                .accountId(account.getId())
                .nickname(account.getNickname())
                .profileImage(account.getProfileImage())
                .follower(account.getFollower())
                .following(account.getFollowing())
                .createdAt(account.getCreatedAt())
                .build();
    }
}
