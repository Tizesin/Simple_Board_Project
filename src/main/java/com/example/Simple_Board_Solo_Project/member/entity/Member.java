package com.example.Simple_Board_Solo_Project.member.entity;


import com.example.Simple_Board_Solo_Project.member.dto.MemberDto;
import com.example.Simple_Board_Solo_Project.question.entity.Like;
import com.example.Simple_Board_Solo_Project.question.entity.Question;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity(name = "MEMBER")
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long memberId;

    @Column(nullable = false, length = 30)
    private String name;

    @Column(nullable = false,updatable = false,length = 100)
    private String email;

    @Column(nullable = false,length = 100)
    private String password;

    @JsonManagedReference
    @OneToMany(mappedBy = "member")
    private List<Question> questions = new ArrayList<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "member")
    private List<Like> likes = new ArrayList<>();
//
//    public Member(Long memberId, String name, String email, String password) {
//        this.memberId = memberId;
//        this.name = name;
//        this.email = email;
//        this.password = password;
//    }
}
