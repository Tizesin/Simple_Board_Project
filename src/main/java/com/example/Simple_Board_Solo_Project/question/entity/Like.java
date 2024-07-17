package com.example.Simple_Board_Solo_Project.question.entity;

import com.example.Simple_Board_Solo_Project.member.entity.Member;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import org.mapstruct.Mapper;

import javax.persistence.*;

@Getter
public class Like {
    @Id
    private long LikeId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "MEMBER_ID")
    @JsonBackReference
    private Member member;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonBackReference
    private Question question;
}
