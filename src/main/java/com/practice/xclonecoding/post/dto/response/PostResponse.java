package com.practice.xclonecoding.post.dto.response;

import com.practice.xclonecoding.post.domain.Post;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class PostResponse {

    private Long postId;
    private String nickname;
    private String content;
    private String image;
    private LocalDateTime createdAt;

    public static PostResponse from(Post post) {
        return PostResponse.builder()
                .postId(post.getId())
                .nickname(post.getWriter().getNickname())
                .content(post.getContent())
                .image(post.getImage())
                .createdAt(post.getCreatedAt())
                .build();
    }
}
