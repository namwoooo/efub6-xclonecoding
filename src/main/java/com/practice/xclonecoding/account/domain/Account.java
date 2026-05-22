package com.practice.xclonecoding.account.domain;

import com.practice.xclonecoding.global.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@Table(name = "accounts")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Account extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long id;

    @Column(nullable = false)
    private String nickname;

    @Column(name = "profile_image", nullable = true)
    private String profileImage;

    @Column(nullable = false)
    private Long follower;

    @Column(nullable = false)
    private Long following;

    public Account(String nickname, String profileImage, Long follower, Long following) {
        this.nickname = nickname;
        this.profileImage = profileImage;
        this.follower = follower;
        this.following = following;
    }
}
