package com.example.Simple_Board_Solo_Project.answer.controller;

import com.example.Simple_Board_Solo_Project.answer.entity.Answer;
import com.example.Simple_Board_Solo_Project.answer.service.AnswerService;
import com.example.Simple_Board_Solo_Project.dto.SingleResponseDto;
import com.example.Simple_Board_Solo_Project.utils.UriCreator;
import com.example.Simple_Board_Solo_Project.answer.dto.AnswerDto;
import com.example.Simple_Board_Solo_Project.answer.mapper.AnswerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.net.URI;

@RestController
@RequestMapping("/answer")
@RequiredArgsConstructor
public class AnswerController {
    private final static String ANSWER_DEF_URL = "/answer";
    private final AnswerService service;
    private final AnswerMapper mapper;

    @PostMapping
    public ResponseEntity postAnswer(@RequestBody AnswerDto.Post requestBody) {
        Answer answer = service.createAnswer(mapper.answerPostToAnswer(requestBody));
        URI location = UriCreator.createUri(ANSWER_DEF_URL, answer.getAnswerId());
        return ResponseEntity.created(location).build();
    }

    @PatchMapping("/{answer-id}")
    public ResponseEntity patchAnswer(@PathVariable("answer-id") @Positive long answerId,
                                      @RequestBody AnswerDto.Patch requestBody) {
        requestBody.setAnswerId(answerId);
        Answer answer = service.updateAnswer(mapper.answerPatchToAnswer(requestBody));
        return new ResponseEntity<>(
                new SingleResponseDto<>(mapper.answerToAnswerResponse(answer)),
                HttpStatus.OK);
    }

    @DeleteMapping("/{answer-id}")
    public ResponseEntity deleteAnswer(@PathVariable("answer-id") @Positive long answerId) {
        service.deleteAnswer(answerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
