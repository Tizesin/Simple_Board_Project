package com.example.Simple_Board_Solo_Project.question.entity;

import com.example.Simple_Board_Solo_Project.member.entity.Member;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import org.mapstruct.Mapper;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "QUESTION_LIKE")
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long likeId;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    @JsonBackReference
    private Member member;

    @ManyToOne
    @JoinColumn(name = "QUESTION_ID")
    @JsonBackReference
    private Question question;
}
