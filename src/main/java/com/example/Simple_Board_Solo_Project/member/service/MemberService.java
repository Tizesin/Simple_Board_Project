package com.example.Simple_Board_Solo_Project.member.service;

import com.example.Simple_Board_Solo_Project.member.entity.Member;
import com.example.Simple_Board_Solo_Project.exception.BusinessLogicException;
import com.example.Simple_Board_Solo_Project.exception.ExceptionCode;
import com.example.Simple_Board_Solo_Project.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository repository;

    public Member createMember(Member member) {
        verifyExistsEmail(member);
        Member savedMember = repository.save(member);
        return savedMember;
    }

    public Member updateMember(Member member) {

        Member findMember = findVerifiedMember(member);

        Optional.ofNullable(member.getName())
                .ifPresent(name -> findMember.setName(name));
        Optional.ofNullable(member.getPassword())
                .ifPresent(password -> findMember.setPassword(password));

        return repository.save(findMember);
    }

    private Member findVerifiedMember(Member member) {
        Optional<Member> optionalMember = repository.findByEmail(member.getEmail());
        Member findMember =
                optionalMember.orElseThrow(() ->
             new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));
        return findMember;
    }

    private void verifyExistsEmail(Member member) {
        if(repository.findByEmail(member.getEmail()).isPresent())
            throw new BusinessLogicException(ExceptionCode.MEMBER_EXISTS);
    }
}
