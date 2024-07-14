package com.example.Simple_Board_Solo_Project.question.dto;

import com.example.Simple_Board_Solo_Project.answer.entity.Answer;
import com.example.Simple_Board_Solo_Project.member.entity.Member;
import com.example.Simple_Board_Solo_Project.question.entity.Question;
import com.example.Simple_Board_Solo_Project.question.entity.Question.QuestionType;
import lombok.*;

import javax.validation.constraints.NotBlank;

public class QuestionDto {
    @Getter
    @AllArgsConstructor
    public static class Post{
        @NotBlank
        private String title;

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

    @Getter
    @Setter
    public static class Patch{

        private long questionId;

        @NotBlank
        private String title;

        @NotBlank
        private String content;

        @NotBlank
        private Question.QuestionType questionType;

    }

    @Getter
    @Setter
    @NoArgsConstructor
    @Builder
    @AllArgsConstructor
    public static class Response {
        private String title;

        private String content;
//        private String fileName;
//        private String filePath;
//        private Member member;
        private String questionType;
        private String questionStatus;
        private Answer answer;
        private int viewCnt;
    }
}
