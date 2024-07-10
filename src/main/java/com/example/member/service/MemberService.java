package com.example.member.service;

import com.example.exception.BusinessLogicException;
import com.example.exception.ExceptionCode;
import com.example.member.entity.Member;
import com.example.member.repository.MemberRepository;
import org.springframework.context.ApplicationEventPublisher;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository repository;

    public Member createMember(Member member) {
        verifyExistsEmail(member);
        Member savedMember = repository.save(member);
        return savedMember;
    }

    private void verifyExistsEmail(Member member) {
        if(repository.findByEmail(member.getEmail()).isPresent())
            throw new BusinessLogicException(ExceptionCode.MEMBER_EXISTS);
    }
}
