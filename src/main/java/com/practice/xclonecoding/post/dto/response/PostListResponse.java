package com.practice.xclonecoding.post.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class PostListResponse {

    private List<PostResponse> postList;
    private int total;

    public static PostListResponse from (List<PostResponse> postList) {
        return new PostListResponse(postList, postList.size());
    }
}
