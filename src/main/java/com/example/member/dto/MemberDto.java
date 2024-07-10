package com.example.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

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
    @AllArgsConstructor
    public static class Patch {

        private long memberId;

        @NotBlank
        private String name;

        @NotBlank
        private String password;
    }
}
