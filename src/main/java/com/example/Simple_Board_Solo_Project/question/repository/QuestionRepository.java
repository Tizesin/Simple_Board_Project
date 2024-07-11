package com.example.Simple_Board_Solo_Project.question.repository;

import com.example.Simple_Board_Solo_Project.question.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Long> {
//    Optional<Question> findBy
}
