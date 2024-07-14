package com.example.Simple_Board_Solo_Project.answer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

public class AnswerDto {

    @Getter
    @AllArgsConstructor
    public static class Post{
        @NotBlank
        private String title;

        @NotBlank
        private String content;

        @Setter
        private long questionId;

    }

    @AllArgsConstructor
    public static class Patch {
        private long answerId;

        @NotBlank
        private String title;

        @NotBlank
        private String content;

        public void setAnswerId(long answerId) {
            this.answerId = answerId;
        }
    }

    @Getter
    @Setter
    @NoArgsConstructor
    public static class Response {
        private long answerId;
        private String title;
        private String content;
        private long questionId;
    }
}
