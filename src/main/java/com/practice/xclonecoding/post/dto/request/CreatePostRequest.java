package com.practice.xclonecoding.post.dto.request;

import com.practice.xclonecoding.account.domain.Account;
import com.practice.xclonecoding.post.domain.Post;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class CreatePostRequest {

    @NotNull
    private String content;

    private String image;

    public Post toEntity(Account account) {
        return Post.builder()
                .content(content)
                .image(image)
                .writer(account)
                .build();
    }
}
