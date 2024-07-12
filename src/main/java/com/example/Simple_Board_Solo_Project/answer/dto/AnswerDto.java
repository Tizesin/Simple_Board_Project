package com.example.Simple_Board_Solo_Project.answer.dto;

import lombok.Setter;

import javax.validation.constraints.NotBlank;

public class AnswerDto {
    public static class Post{
        @NotBlank
        private String title;

        @NotBlank
        private String content;

        @NotBlank
        @Setter
        private long questionId;
    }

    public static class Patch {
        @Setter
        private long answerId;

        @NotBlank
        private String title;

        @NotBlank
        private String content;
    }

    public static class Response {
        private long answerId;
        private String title;
        private String content;
        private long questionId;
    }
}
