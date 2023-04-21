package com.reserve.reservation.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    USER_NOT_FOUND(HttpStatus.BAD_REQUEST, "회원을 찾을 수 없습니다."),
    WRONG_NAME(HttpStatus.BAD_REQUEST, "매장을 찾을 수 없습니다.")
    ;


    private final HttpStatus httpStatus;
    private final String detail;
}
