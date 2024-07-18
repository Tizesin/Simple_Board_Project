package com.example.Simple_Board_Solo_Project.question.service;

import com.example.Simple_Board_Solo_Project.exception.BusinessLogicException;
import com.example.Simple_Board_Solo_Project.exception.ExceptionCode;
import com.example.Simple_Board_Solo_Project.member.entity.Member;
import com.example.Simple_Board_Solo_Project.member.repository.MemberRepository;
import com.example.Simple_Board_Solo_Project.question.entity.Like;
import com.example.Simple_Board_Solo_Project.question.entity.Question;
import com.example.Simple_Board_Solo_Project.question.repository.LikeRepository;
import com.example.Simple_Board_Solo_Project.question.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

import static com.example.Simple_Board_Solo_Project.exception.ExceptionCode.MEMBER_EXISTS;

@Service
@Transactional
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionRepository repository;
    private final MemberRepository memberRepository;
    private final LikeRepository likeRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public Question createQuestion(Question question) {
        Question savedQuestion = repository.save(question);
        return savedQuestion;
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

    public Question getQuestion(Question question) {
        int viewCnt = question.getViewCnt();
        viewCnt++;
        question.setViewCnt(viewCnt);
        return repository.save(question);
    }

    public void deleteQuestion(long questionId) {
        Question findQuestion = findVerifiedQuestion(questionId);
        findQuestion.setQuestionStatus(Question.QuestionStatus.QUESTION_DELETED);
    }

    @Transactional(readOnly = true)
    public Question findVerifiedQuestion(long questionId) {
        Optional<Question> findQuestion =
                repository.findById(questionId);
        Question result = findQuestion.orElseThrow(()->
                new BusinessLogicException(ExceptionCode.QUESTION_NOT_FOUND));
        return result;
    }

    public Page<Question> findQuestions(int page, int size) {
        return repository.findAll(PageRequest.of(page, size, Sort.by("questionId").descending()));
    }

    public void switchLike(Like like) {
        Question question = findVerifiedQuestion(like.getQuestion().getQuestionId());
        Member member = memberRepository.findById(like.getMember().getMemberId()).orElseThrow(()->
                new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));
        if(likeRepository.findByMember(member).isPresent()) {
            likeRepository.delete(like);
//            entityManager.flush(); // 변경 사항을 데이터베이스에 즉시 반영
            question.setLikeCnt(question.getLikeCnt()-1);
        }else{
            likeRepository.save(like);
            question.setLikeCnt(question.getLikeCnt()+1);
        }
        entityManager.flush(); // 변경 사항을 데이터베이스에 즉시 반영
        repository.save(question);
        entityManager.clear();
    }
}
