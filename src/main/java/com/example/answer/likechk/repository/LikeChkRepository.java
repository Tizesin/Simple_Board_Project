package com.example.answer.likechk.repository;

import com.example.answer.likechk.entity.LikeChk;
import com.example.Simple_Board_Solo_Project.member.entity.Member;
import com.example.Simple_Board_Solo_Project.question.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikeChkRepository extends JpaRepository<LikeChk,Long> {
    Optional<LikeChk> findByMember(Member member);
    Optional<LikeChk> findByQuestion(Question question);
}
