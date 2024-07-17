package com.example.likechk.service;

import com.example.Simple_Board_Solo_Project.member.repository.MemberRepository;
import com.example.Simple_Board_Solo_Project.member.service.MemberService;
import com.example.Simple_Board_Solo_Project.question.repository.QuestionRepository;
import com.example.Simple_Board_Solo_Project.question.service.QuestionService;
import com.example.likechk.dto.LikeChkDto;
import com.example.likechk.entity.LikeChk;
import com.example.likechk.mapper.LikeChkMapper;
import com.example.likechk.repository.LikeChkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LikeChkService {
    private static MemberRepository memberRepository;
    private static QuestionRepository questionRepository;
    private static LikeChkRepository likeChkRepository;
    private static MemberService memberService;
    private static QuestionService questionService;

    public LikeChk pushLikeButton(LikeChk likeChk) {
    }
}
