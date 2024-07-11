package com.example.Simple_Board_Solo_Project.question.controller;

import com.example.Simple_Board_Solo_Project.dto.SingleResponseDto;
import com.example.Simple_Board_Solo_Project.member.dto.MemberDto;
import com.example.Simple_Board_Solo_Project.member.entity.Member;
import com.example.Simple_Board_Solo_Project.question.service.QuestionService;
import com.example.Simple_Board_Solo_Project.question.dto.QuestionDto;
import com.example.Simple_Board_Solo_Project.question.entity.Question;
import com.example.Simple_Board_Solo_Project.question.mapper.QuestionMapper;
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
    public ResponseEntity PostQuestion(@Valid @RequestBody
                                       QuestionDto.Post requestBody) {
        Member member = new Member();
        member.setMemberId(requestBody.get)
        Question createQuestion =
                service.createQuestion(mapper.questionDtoPostToquestion(requestBody));

        URI location = UriCreator.createUri(QUESTION_DEF_URL, createQuestion.getQuestionId());

        return ResponseEntity.created(location).build();
    }

//    @PostMapping
//    public ResponseEntity postMember(@Valid @RequestBody MemberDto.Post requestBody) {
//        Member createMember = service.createMember(mapper.memberPostToMember(requestBody));
//        URI uri = URI.create(MEMBER_DEF_URL + createMember.getMemberId());
//        return ResponseEntity.created(uri).build();
//    }

    @GetMapping("/{question-Id}")
    public ResponseEntity GetQuestion(@PathVariable("question-Id")
                                     @Positive long questionId) {
        Question findQuestion = service.findQuestion(questionId);
        return new ResponseEntity<>(
                new SingleResponseDto<>(mapper.questionToQuestionDtoResponse(findQuestion)),
                HttpStatus.OK);
    }
}
