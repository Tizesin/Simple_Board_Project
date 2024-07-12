package com.example.Simple_Board_Solo_Project.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class MemberDto {
    @AllArgsConstructor
    public static class Post {
        public String getEmail() {
            return email;
        }

        public String getName() {
            return name;
        }

        public String getPassword() {
            return password;
        }

        @NotBlank
        @Email
        private String email;

        @NotBlank
        private String name;

        @NotBlank
        private String password;
    }

    @AllArgsConstructor
    public static class Patch {
        public long getMemberId() {
            return memberId;
        }

        public String getName() {
            return name;
        }

        public String getPassword() {
            return password;
        }

        @Setter
        private long memberId;

        @NotBlank
        private String name;

        @NotBlank
        private String password;
    }

    @NoArgsConstructor
    public static class Response {
        public long getMemberId() {
            return memberId;
        }

        public void setMemberId(long memberId) {
            this.memberId = memberId;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        private long memberId;
        private String email;
        private String name;
        private String password;

    }
}
