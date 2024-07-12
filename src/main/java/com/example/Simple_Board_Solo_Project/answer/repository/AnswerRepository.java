package com.example.Simple_Board_Solo_Project.answer.repository;

import com.example.Simple_Board_Solo_Project.answer.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer,Long> {
}
