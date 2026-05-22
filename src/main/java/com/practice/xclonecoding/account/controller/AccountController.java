package com.practice.xclonecoding.account.controller;

import com.practice.xclonecoding.account.domain.Account;
import com.practice.xclonecoding.account.dto.request.CreateAccountRequest;
import com.practice.xclonecoding.account.dto.response.AccountResponse;
import com.practice.xclonecoding.account.service.AccountService;
import com.practice.xclonecoding.post.dto.response.PostListResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    // 회원 생성
    @PostMapping
    public ResponseEntity<AccountResponse> createAccount(@Valid @RequestBody CreateAccountRequest request) {
        AccountResponse response = accountService.createAccount(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // 회원 조회
    @GetMapping("/{accountId}")
    public ResponseEntity<AccountResponse> getAccount(@PathVariable("accountId") Long accountId) {
        AccountResponse response = accountService.getAccount(accountId);
        return ResponseEntity.ok(response);
    }

    // 회원 별 게시물 조회
    @GetMapping("/{accountId}/posts")
    public ResponseEntity<PostListResponse> getAccountPosts(@PathVariable("accountId") Long accountId) {
        PostListResponse response = accountService.getAccountPosts(accountId);
        return ResponseEntity.ok(response);
    }
}
