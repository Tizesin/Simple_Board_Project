package com.example.Simple_Board_Solo_Project.question.controller;

import com.example.Simple_Board_Solo_Project.dto.SingleResponseDto;
import com.example.Simple_Board_Solo_Project.member.entity.Member;
import com.example.Simple_Board_Solo_Project.question.dto.QuestionDto;
import com.example.Simple_Board_Solo_Project.question.entity.Question;
import com.example.Simple_Board_Solo_Project.question.mapper.QuestionMapper;
import com.example.Simple_Board_Solo_Project.question.service.QuestionService;
import com.example.Simple_Board_Solo_Project.utils.UriCreator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.net.URI;

@RestController
@RequestMapping("/questions")
@Validated
@RequiredArgsConstructor
public class QuestionController {
    private final static String QUESTION_DEF_URL = "/questions";
    private final QuestionMapper mapper;
    private final QuestionService service;

    @PostMapping
    public ResponseEntity postQuestion(@Valid @RequestBody
                                       QuestionDto.Post requestBody) {
        Member member = new Member();
        member.setMemberId(requestBody.getMemberId());
        Question createQuestion =
                service.createQuestion(mapper.questionDtoPostToQuestion(requestBody));

        URI location = UriCreator.createUri(QUESTION_DEF_URL, createQuestion.getQuestionId());

        return ResponseEntity.created(location).build();
    }

    @PatchMapping("/{question-Id}")
    public ResponseEntity patchQuestion(@PathVariable("question-Id") @Positive long questionId
            , @Valid @RequestBody QuestionDto.Patch requestBody) {
        requestBody.setQuestionId(questionId);
        Question patchQuestion = service.patchQuestion(mapper.questionDtoPatchToQuestion(requestBody));
        return new ResponseEntity<>(
                new SingleResponseDto<>(mapper.questionToQuestionDtoResponse(patchQuestion)),
                HttpStatus.OK);
    }

    @GetMapping("/{question-Id}")
    public ResponseEntity getQuestion(@PathVariable("question-Id")
                                      @Positive long questionId) {
        Question findQuestion = service.findVerifiedQuestion(questionId);
        return new ResponseEntity<>(
                new SingleResponseDto<>(mapper.questionToQuestionDtoResponse(findQuestion)),
                HttpStatus.OK);
    }

    @DeleteMapping("/{question-Id}")
    public ResponseEntity deleteQuestion(@PathVariable("question-Id") @Positive long questionId) {
        service.deleteQuestion(questionId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

//    @GetMapping
//    public ResponseEntity GetQuestions(@Positive @RequestParam int page,
//                                       @Positive @RequestParam int size){
//        Page<Answer> pageAnswer = service.findAnswers(page - 1, size);
//        List<Answer> orders = pageAnswers.getContent();
//
//        return new ResponseEntity<>(
//                new MultiResponseDto<>(mapper.ordersToOrderResponseDtos(orders), pageOrders),
//                HttpStatus.OK);
//
//    }
}
