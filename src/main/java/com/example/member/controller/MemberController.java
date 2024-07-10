package com.example.member.controller;

import com.example.member.dto.MemberDto;
import com.example.member.mapper.MemberMapper;
import com.example.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {
    private final MemberMapper mapper;
    private final MemberService service;

    @PostMapping
    public ResponseEntity postMember(@Valid @RequestBody MemberDto.Post requestBody){
        service.createMember(mapper.memberPostToMember(requestBody));
        return ResponseEntity.created();
    }

    @PatchMapping
    public ResponseEntity patchMember(){

    }

    @GetMapping
    public ResponseEntity getMember() {

    }
}
