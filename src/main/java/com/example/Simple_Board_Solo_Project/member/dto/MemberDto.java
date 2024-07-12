package com.example.Simple_Board_Solo_Project.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class MemberDto {
    @Getter
    @AllArgsConstructor
    public static class Post {
        @NotBlank
        @Email
        private String email;

        @NotBlank
        private String name;

        @NotBlank
        private String password;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Patch {

        private long memberId;

        @NotBlank
        private String name;

        @NotBlank
        private String password;
    }

    @AllArgsConstructor
    @Getter
    @Setter
    public static class Response {
        private long memberId;
        private String email;
        private String name;
        private String password;
    }
}
