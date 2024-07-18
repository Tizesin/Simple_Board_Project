package com.example.Simple_Board_Solo_Project.question.repository;


import com.example.Simple_Board_Solo_Project.member.entity.Member;
import com.example.Simple_Board_Solo_Project.question.entity.Like;
import com.example.Simple_Board_Solo_Project.question.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LikeRepository extends JpaRepository<Like,Long> {
    Optional<Like> findByMember(Member member);
    Optional<Like> findByMemberAndQuestion(Member member, Question question);
}
