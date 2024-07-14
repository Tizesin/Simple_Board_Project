package com.example.Simple_Board_Solo_Project.question.repository;

import com.example.Simple_Board_Solo_Project.member.entity.Member;
import com.example.Simple_Board_Solo_Project.question.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Long> {
    List<Question> findByMember(Member member);
}
