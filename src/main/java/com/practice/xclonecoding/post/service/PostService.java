package com.practice.xclonecoding.post.service;

import com.practice.xclonecoding.account.domain.Account;
import com.practice.xclonecoding.account.service.AccountService;
import com.practice.xclonecoding.global.exception.CustomException;
import com.practice.xclonecoding.global.exception.ErrorCode;
import com.practice.xclonecoding.post.domain.Post;
import com.practice.xclonecoding.post.dto.request.CreatePostRequest;
import com.practice.xclonecoding.post.dto.response.PostListResponse;
import com.practice.xclonecoding.post.dto.response.PostResponse;
import com.practice.xclonecoding.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {

    private final AccountService accountService;
    private final PostRepository postRepository;

    // 게시물 생성
    @Transactional
    public PostResponse createPost(Long accountId, CreatePostRequest request) {
        Account writer = accountService.findByAccountId(accountId);
        Post newPost = request.toEntity(writer);

        postRepository.save(newPost);
        return PostResponse.from(newPost);
    }

    // 게시물 전체 조회
    public PostListResponse getPostList() {
        List<PostResponse> postList = postRepository.findAllByOrderByCreatedAtDesc()
                .stream()
                .map(PostResponse::from)
                .toList();
        return PostListResponse.from(postList);
    }

    // 게시물 상세 조회
    public PostResponse getPostDetail(Long postId) {
        Post post = findByPostId(postId);
        return PostResponse.from(post);
    }

    // 게시물 삭제
    @Transactional
    public void deletePost(Long postId, Long accountId) {
        Post post = findByPostId(postId);
        if (!post.getWriter().getId().equals(accountId)) {
            throw new CustomException(ErrorCode.POST_ACCOUNT_MISMATCH);
        }
        postRepository.delete(post);
    }

    // ----------- helper function --------- //
    private Post findByPostId(Long postId) {
        return postRepository.findById(postId)
                .orElseThrow(() -> new CustomException(ErrorCode.POST_NOT_FOUND));
    }
//
//    private void authorizePostAccount(Post post, Account account) {
//        if (!post.getWriter().equals(account)) {
//            throw new CustomException(ErrorCode.POST_ACCOUNT_MISMATCH);
//        }
//    }
}
