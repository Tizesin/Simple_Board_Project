package com.example.Simple_Board_Solo_Project.question.dto;

import lombok.AllArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

public class LikeDto {
    @AllArgsConstructor
    public static class Post {
        @NotBlank
        private long memberId;

        @Setter
        private long questionId;
    }
}
