package com.example.Simple_Board_Solo_Project.question.entity;

import com.example.Simple_Board_Solo_Project.answer.entity.Answer;
import com.example.Simple_Board_Solo_Project.audit.Auditable;
import com.example.Simple_Board_Solo_Project.member.entity.Member;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Question extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "MEMBER_ID")
    private Member member;
//
//    @OneToMany
//    @JsonBackReference
//    private List<LikeChk> likeChks = new ArrayList<>();
//
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ANSWER_ID")
    private Answer answer;

//    @Column
//    private int likeCnt = 0;

    @Column
    private int viewCnt = 0;

    @Column
    @Enumerated(value = EnumType.STRING)
    private QuestionStatus questionStatus = QuestionStatus.QUESTION_REGISTERED;

    @Column
    @Enumerated(value = EnumType.STRING)
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
