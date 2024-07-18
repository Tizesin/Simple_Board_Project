package com.example.Simple_Board_Solo_Project.question.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

public class LikeDto {
    @Getter
    @AllArgsConstructor
    public static class Post {

        private long memberId;

        @Setter
        private long questionId;
    }
}
