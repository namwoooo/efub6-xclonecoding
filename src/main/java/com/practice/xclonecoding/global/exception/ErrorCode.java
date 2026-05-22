package com.practice.xclonecoding.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    INTERNAL_SERVER_ERROR(500, "서버 에러가 발생했습니다."),
    ERROR(400, "요청 처리에 실패했습니다."),

    // account
    ACCOUNT_NOT_FOUND(404, "존재하지 않는 계정입니다."),
    ACCOUNT_ALREADY_EXIST(400, "이미 존재하는 닉네임입니다."),

    // post
    POST_NOT_FOUND(404, "존재하지 않는 게시물입니다."),
    POST_ACCOUNT_MISMATCH(401, "게시글 생성자가 아닙니다.");

    private final int status;
    private final String message;
}
