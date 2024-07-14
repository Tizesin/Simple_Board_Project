package com.example.Simple_Board_Solo_Project.member.controller;

import com.example.Simple_Board_Solo_Project.dto.SingleResponseDto;
import com.example.Simple_Board_Solo_Project.member.dto.MemberDto;
import com.example.Simple_Board_Solo_Project.member.entity.Member;
import com.example.Simple_Board_Solo_Project.member.mapper.MemberMapper;
import com.example.Simple_Board_Solo_Project.member.service.MemberService;
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
@RequestMapping("/members")
@Validated
@RequiredArgsConstructor
public class MemberController {
    private final static String MEMBER_DEF_URL = "/members";
    private final MemberMapper mapper;
    private final MemberService service;

    @PostMapping
    public ResponseEntity postMember(@Valid @RequestBody MemberDto.Post requestBody) {
        Member createMember = service.createMember(mapper.memberPostDToToMember(requestBody));
        URI location = UriCreator.createUri(MEMBER_DEF_URL,createMember.getMemberId());
        return ResponseEntity.created(location).build();
    }

    @PatchMapping("/{member-id}")
    public ResponseEntity patchMember(@PathVariable("member-id") @Positive long memberId,
                                      @Valid @RequestBody MemberDto.Patch requestBody) {
        requestBody.setMemberId(memberId);
        Member member =
                service.updateMember(mapper.memberPatchToMember(requestBody));
        return new ResponseEntity<>(
                new SingleResponseDto<>(mapper.memberToMemberResponseDto(member)),
                        HttpStatus.OK);
    }

    @DeleteMapping("/{member-id}")
    public ResponseEntity delete(@PathVariable("member-id") @Positive long memberId) {
        service.deleteMember(memberId);
        return new ResponseEntity(HttpStatus.OK);
    }
//    @GetMapping
//    public ResponseEntity getMember() {
//
//    }
}
