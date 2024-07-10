package com.example.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

@AllArgsConstructor
public enum ExceptionCode {
    MEMBER_EXISTS(409,"Member exists");

    @Getter
    private int status;

    @Getter
    private String msg;

}
