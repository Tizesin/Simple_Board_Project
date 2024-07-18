package com.example.Simple_Board_Solo_Project.member.service;

import com.example.Simple_Board_Solo_Project.member.entity.Member;
import com.example.Simple_Board_Solo_Project.exception.BusinessLogicException;
import com.example.Simple_Board_Solo_Project.exception.ExceptionCode;
import com.example.Simple_Board_Solo_Project.member.repository.MemberRepository;
import com.example.Simple_Board_Solo_Project.question.entity.Question;
import com.example.Simple_Board_Solo_Project.question.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {
    private final MemberRepository memberRepository;
    private final QuestionRepository questionRepository;

    public Member createMember(Member member) {
        verifyExistsEmail(member);
        Member savedMember = memberRepository.save(member);
        return savedMember;
    }

    public Member updateMember(Member member) {

        Member findMember = findVerifiedMember(member);

        Optional.ofNullable(member.getName())
                .ifPresent(name -> findMember.setName(name));
        Optional.ofNullable(member.getPassword())
                .ifPresent(password -> findMember.setPassword(password));

        return memberRepository.save(findMember);
    }

    public void deleteMember(long memberId) {
        Member findMember = findVerifiedMember(memberId);
        List<Question> findQuestion = questionRepository.findByMember(findMember);
        findQuestion.stream()
                        .forEach(question -> {
                            question.setQuestionStatus(Question.QuestionStatus.QUESTION_DEACTIVED);
                            question.setMember(null);
                            questionRepository.save(question);
                        });
        memberRepository.delete(findMember);
    }

    private Member findVerifiedMember(Member member) {
        Optional<Member> optionalMember = memberRepository.findByEmail(member.getEmail());
        Member findMember =
                optionalMember.orElseThrow(() ->
             new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));
        return findMember;
    }

    private Member findVerifiedMember(long memberId) {
        Optional<Member> optionalMember = memberRepository.findById(memberId);
        Member findMember =
                optionalMember.orElseThrow(() ->
                        new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));
        return findMember;
    }

    private void verifyExistsEmail(Member member) {
        if(memberRepository.findByEmail(member.getEmail()).isPresent())
            throw new BusinessLogicException(ExceptionCode.MEMBER_EXISTS);
    }
}
