package com.example.Simple_Board_Solo_Project.answer.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

public class AnswerDto {

    @AllArgsConstructor
    public static class Post{
        @NotBlank
        private String title;

        @NotBlank
        private String content;

        private long questionId;

        public void setQuestionId(long questionId) {
            this.questionId = questionId;
        }
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

    @NoArgsConstructor
    public static class Response {
        private long answerId;
        private String title;
        private String content;
        private long questionId;

        public long getAnswerId() {
            return answerId;
        }

        public void setAnswerId(long answerId) {
            this.answerId = answerId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public long getQuestionId() {
            return questionId;
        }

        public void setQuestionId(long questionId) {
            this.questionId = questionId;
        }
    }
}
