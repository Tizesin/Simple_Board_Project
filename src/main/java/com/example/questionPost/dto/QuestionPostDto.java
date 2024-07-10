package com.example.questionPost.dto;

import com.example.questionPost.entity.QuestionPost.QuestionType;

import javax.validation.constraints.NotBlank;

public class QuestionPostDto {
    public static class Post{
        @NotBlank
        private String title;

        @NotBlank
        private String text;

        private String fileName;

        private String filePath;

        private String memberId;

        private QuestionType questionType;
    }
}
