package com.example.Simple_Board_Solo_Project.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

@AllArgsConstructor
public enum ExceptionCode {
    QUESTION_NOT_FOUND(404,"Question Not Found"),
    MEMBER_NOT_FOUND(404,"Member Not Found"),
    MEMBER_EXISTS(409,"Member exists");

    @Getter
    private int status;

    @Getter
    private String msg;

}
