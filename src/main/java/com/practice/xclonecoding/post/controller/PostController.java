package com.practice.xclonecoding.post.controller;

import com.practice.xclonecoding.post.dto.request.CreatePostRequest;
import com.practice.xclonecoding.post.dto.response.PostListResponse;
import com.practice.xclonecoding.post.dto.response.PostResponse;
import com.practice.xclonecoding.post.service.PostService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    // 게시물 생성
    @PostMapping
    public ResponseEntity<PostResponse> createPost(@RequestHeader("Auth-Id") Long accountId,
                                                   @RequestBody CreatePostRequest request) {
        PostResponse response = postService.createPost(accountId, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // 게시물 전체 조회
    @GetMapping
    public ResponseEntity<PostListResponse> getPostList() {
        PostListResponse postList = postService.getPostList();
        return ResponseEntity.ok(postList);
    }

    // 게시물 상세 조회
    @GetMapping("/{postId}")
    public ResponseEntity<PostResponse> getPostDetail(@PathVariable("postId") Long postId) {
        PostResponse response = postService.getPostDetail(postId);
        return ResponseEntity.ok(response);
    }

    // 게시물 삭제
    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable("postId") Long postId,
                                           @RequestHeader("Auth-Id") Long accountId) {
        postService.deletePost(postId, accountId);
        return ResponseEntity.noContent().build();
    }
}
