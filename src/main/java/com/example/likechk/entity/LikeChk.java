package com.example.likechk.entity;

import com.example.Simple_Board_Solo_Project.member.entity.Member;
import com.example.Simple_Board_Solo_Project.question.entity.Question;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@Entity
public class LikeChk {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long LikeId;

//    @ManyToOne
//    @JsonManagedReference
//    @JoinColumn(name = "MEMBER_ID")
//    private Member member;
//
//    @ManyToOne
//    @JsonManagedReference
//    @JoinColumn(name = "QUESTION_ID")
//    private Question question;
}
