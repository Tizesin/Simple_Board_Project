package com.example.likechk.dto;

import lombok.AllArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

public class LikeChkDto {
    @AllArgsConstructor
    public static class Post {

        @NotBlank
        private long questionId;

        @NotBlank
        private long memberId;

    }
}
