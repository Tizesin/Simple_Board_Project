package com.example.answerPost.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Getter
@Setter
@Entity
public class AnswerPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long answerPostId;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String text;

    @Column
    private Date createAt;

    @Column(nullable = false)
    private Long postUser;

    @Column
    private int likeCnt = 0;

    @Column
    private int watchCnt = 0;

    @Column
    private QuestionStatus questionStatus = QuestionStatus.QUESTION_REGISTERED;

    @Column
    private QuestionType questionType = QuestionType.PUBLIC;

    @AllArgsConstructor
    public enum QuestionStatus{
        QUESTION_REGISTERED(1,"질문 등록 상태"),
        QUESTION_ANSWERED(2,"답변 완료 상태"),
        QUESTION_DELETED(3,"질문 삭제 상태"),
        QUESTION_DEACTIVED(4,"질문 비활성화 상태"); //: 회원 탈퇴 시, 질문 비활성화 상태

        @Getter
        private int statusNumber;

        @Getter
        private String statusDescription;
    }

    @AllArgsConstructor
    public enum QuestionType{
        PUBLIC(1,"공개글 상태"),
        SECRET(2,"비밀글 상태");

        @Getter
        private int typeNumber;

        @Getter
        private String typeDescription;
    }
}
