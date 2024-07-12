package com.example.Simple_Board_Solo_Project.answer.service;

import com.example.Simple_Board_Solo_Project.answer.entity.Answer;
import com.example.Simple_Board_Solo_Project.exception.BusinessLogicException;
import com.example.Simple_Board_Solo_Project.exception.ExceptionCode;
import com.example.Simple_Board_Solo_Project.question.entity.Question;
import com.example.Simple_Board_Solo_Project.question.repository.QuestionRepository;
import com.example.Simple_Board_Solo_Project.answer.repository.AnswerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AnswerService {
    private final AnswerRepository repository;
    private final QuestionRepository questionRepository;

    public Answer createAnswer(Answer answer) {
        Answer savedAnswer = repository.save(answer);
        changeQuestionAToB(answer, Question.QuestionStatus.QUESTION_REGISTERED,
                Question.QuestionStatus.QUESTION_ANSWERED);
        return savedAnswer;
    }

    public Answer updateAnswer(Answer answer) {
        Answer findAnswer = findVerifiedAnswer(answer.getAnswerId());
        Optional.ofNullable(answer.getTitle())
                .ifPresent(title -> findAnswer.setTitle(title));
        Optional.ofNullable(answer.getContent())
                .ifPresent(content -> answer.setContent(content));
        return repository.save(findAnswer);
    }

    public void deleteAnswer(long answerId) {
        Answer findAnswer = findVerifiedAnswer(answerId);
        changeQuestionAToB(findAnswer, Question.QuestionStatus.QUESTION_ANSWERED,
                Question.QuestionStatus.QUESTION_REGISTERED);
        repository.delete(findAnswer);
    }

    @Transactional(readOnly = true)
    private Answer findVerifiedAnswer(long answerId) {
        Optional<Answer> findAnswer = repository.findById(answerId);
        Answer resultAnswer = findAnswer.orElseThrow(() ->
                new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));
        return resultAnswer;
    }

    private void changeQuestionAToB(Answer answer, Question.QuestionStatus A,
                                        Question.QuestionStatus B) {
        Optional<Question> findQuestion = questionRepository.findById(answer.getAnswerId());
        Question resultQuestion = findQuestion.orElseThrow(() ->
                new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));
        if(resultQuestion.getQuestionStatus().equals(A))
            resultQuestion.setQuestionStatus(B);
        questionRepository.save(resultQuestion);
    }

//    public Page<Answer> findAnswers(int page, int size) {
//        return repository.findAll(PageRequest.of(page, size,
//                Sort.by("orderId").descending()));
//    }
}
