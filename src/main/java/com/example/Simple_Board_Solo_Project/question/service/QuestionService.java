package com.example.Simple_Board_Solo_Project.question.service;

import com.example.Simple_Board_Solo_Project.exception.BusinessLogicException;
import com.example.Simple_Board_Solo_Project.exception.ExceptionCode;
import com.example.Simple_Board_Solo_Project.question.entity.Question;
import com.example.Simple_Board_Solo_Project.question.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionRepository repository;

    public Question createQuestion(Question question) {
        Question savedquestion = repository.save(question);
        return savedquestion;
    }

    public Question patchQuestion(Question question) {
        Optional<Question> findQuestion =
                repository.findById(question.getQuestionId());
        Optional.ofNullable(question.getQuestionType())
                .ifPresent(type -> question.setQuestionType(type));
        Optional.ofNullable(question.getContent())
                .ifPresent(content -> question.setContent(content));
        Optional.ofNullable(question.getTitle())
                .ifPresent(title -> question.setTitle(title));
        return repository.save(question);
    }

    @Transactional(readOnly = true)
    public Question findQuestion(long questionId) {
        return findVerifiedQuestion(questionId);
    }

    public Question findVerifiedQuestion(long questionId) {
        Optional<Question> findQuestion =
                repository.findById(questionId);
        Question result = findQuestion.orElseThrow(()->
                new BusinessLogicException(ExceptionCode.QUESTION_NOT_FOUND));
        return result;
    }
}
