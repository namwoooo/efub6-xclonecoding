package com.practice.xclonecoding.account.service;

import com.practice.xclonecoding.account.domain.Account;
import com.practice.xclonecoding.account.dto.request.CreateAccountRequest;
import com.practice.xclonecoding.account.dto.response.AccountResponse;
import com.practice.xclonecoding.account.repository.AccountRepository;
import com.practice.xclonecoding.global.exception.CustomException;
import com.practice.xclonecoding.global.exception.ErrorCode;
import com.practice.xclonecoding.post.dto.response.PostListResponse;
import com.practice.xclonecoding.post.dto.response.PostResponse;
import com.practice.xclonecoding.post.repository.PostRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AccountService {

    private final AccountRepository accountRepository;
    private final PostRepository postRepository;

    // 회원 생성
    @Transactional
    public AccountResponse createAccount(@Valid CreateAccountRequest request) {
        checkAccountAlreadyExists(request.getNickname());

        Account newAccount = request.toEntity();
        Account savedAccount = accountRepository.save(newAccount);
        return AccountResponse.from(savedAccount);
    }

    // 회원 조회
    public AccountResponse getAccount(Long accountId) {
        Account account = findByAccountId(accountId);
        return AccountResponse.from(account);
    }

    // ------------ helper function ------------- //
    private void checkAccountAlreadyExists(String nickname) {
        if (accountRepository.existsByNickname(nickname)) {
            throw new CustomException(ErrorCode.ACCOUNT_ALREADY_EXIST);
        }
    }

    public Account findByAccountId(Long accountId) {
        return accountRepository.findById(accountId)
                .orElseThrow(() -> new CustomException(ErrorCode.ACCOUNT_NOT_FOUND));
    }

    public PostListResponse getAccountPosts(Long accountId) {
        Account account = findByAccountId(accountId);
        List<PostResponse> postList = postRepository.findByWriterOrderByCreatedAtDesc(account)
                .stream()
                .map(PostResponse::from)
                .toList();
        return PostListResponse.from(postList);
    }
}
