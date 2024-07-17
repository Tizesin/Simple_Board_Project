package com.example.likechk.controller;

import com.example.Simple_Board_Solo_Project.member.dto.MemberDto;
import com.example.likechk.dto.LikeChkDto;
import com.example.likechk.entity.LikeChk;
import com.example.likechk.mapper.LikeChkMapper;
import com.example.likechk.service.LikeChkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/like")
@RequiredArgsConstructor
@Validated
public class LikeChkController {
    private static LikeChkMapper mapper;
    private static LikeChkService service;

//    @PostMapping
//    public ResponseEntity postLikeChk(@RequestBody @Valid LikeChkDto.Post requestBody) {
//        LikeChk likeChk = service.pushLikeButton(mapper.likeChkPostDtoToLikeChk(requestBody));
//
//    }

}
