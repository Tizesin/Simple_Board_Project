package com.example.Simple_Board_Solo_Project.question.dto;

import com.example.Simple_Board_Solo_Project.member.entity.Member;
import com.example.Simple_Board_Solo_Project.question.entity.Question;
import com.example.Simple_Board_Solo_Project.question.entity.Question.QuestionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

public class QuestionDto {
    @AllArgsConstructor
    public static class Post{
        @NotBlank
        private String title;

        public String getTitle() {
            return title;
        }

        public String getContent() {
            return content;
        }

        public long getMemberId() {
            return memberId;
        }

        public QuestionType getQuestionType() {
            return questionType;
        }

        @NotBlank
        private String content;

//        @NotBlank
        private long memberId;

        private Question.QuestionType questionType;
//
//        private String fileName;
//
//        private String filePath;
    }

    public static class Patch{

        private long questionId;

        public long getQuestionId() {
            return questionId;
        }

        public void setQuestionId(long questionId) {
            this.questionId = questionId;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public void setQuestionType(QuestionType questionType) {
            this.questionType = questionType;
        }

        public String getTitle() {
            return title;
        }

        public String getContent() {
            return content;
        }

        public QuestionType getQuestionType() {
            return questionType;
        }

        @NotBlank
        private String title;

        @NotBlank
        private String content;

        @NotBlank
        private Question.QuestionType questionType;

    }

    public static class Response {
        private String title;

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

        public Member getMember() {
            return member;
        }

        public void setMember(Member member) {
            this.member = member;
        }

        public String getQuestionType() {
            return questionType;
        }

        public void setQuestionType(String questionType) {
            this.questionType = questionType;
        }

        public String getQuestionStatus() {
            return questionStatus;
        }

        public void setQuestionStatus(String questionStatus) {
            this.questionStatus = questionStatus;
        }

        private String content;
//        private String fileName;
//        private String filePath;
        private Member member;
        private String questionType;
        private String questionStatus;
    }
}
