package com.example.answer.entity;

import com.example.Simple_Board_Solo_Project.question.entity.Question;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long answerId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String text;

//    @OneToOne
//    @JsonBackReference
//    @JoinColumn(name = "QUESTION_ID")
//    private Question question;

}
