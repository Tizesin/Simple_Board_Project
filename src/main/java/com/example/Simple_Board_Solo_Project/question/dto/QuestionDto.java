package com.example.Simple_Board_Solo_Project.question.dto;

import com.example.Simple_Board_Solo_Project.member.entity.Member;
import com.example.Simple_Board_Solo_Project.question.entity.Question.QuestionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

public class QuestionDto {
    @Getter
    @AllArgsConstructor
    public static class Post{
        @NotBlank
        private String title;

        @NotBlank
        private String content;

//        private String fileName;
//
//        private String filePath;

        private Member memberId;
//
////        private QuestionType questionType;
//
//        public void setMember(Member member) {
//            this.member = member;
//        }
    }

    @Getter
    @Setter
    public static class Response {
        private String title;
        private String content;
//        private String fileName;
//        private String filePath;
        private Member member;
        private String questionType;
        private String questionStatus;
    }
}
