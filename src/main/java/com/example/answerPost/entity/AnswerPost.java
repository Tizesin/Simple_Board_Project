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

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String text;

}
