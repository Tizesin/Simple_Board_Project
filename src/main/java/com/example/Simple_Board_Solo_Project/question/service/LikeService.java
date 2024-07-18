package com.example.Simple_Board_Solo_Project.question.service;

import com.example.Simple_Board_Solo_Project.exception.BusinessLogicException;
import com.example.Simple_Board_Solo_Project.exception.ExceptionCode;
import com.example.Simple_Board_Solo_Project.member.entity.Member;
import com.example.Simple_Board_Solo_Project.member.repository.MemberRepository;
import com.example.Simple_Board_Solo_Project.question.entity.Like;
import com.example.Simple_Board_Solo_Project.question.entity.Question;
import com.example.Simple_Board_Solo_Project.question.repository.LikeRepository;
import com.example.Simple_Board_Solo_Project.question.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class LikeService {
    private final LikeRepository likeRepository;
    private final QuestionRepository questionRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public void toggleLike(Long memberId, Long postId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));
        Question question = questionRepository.findById(postId)
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));

        Optional<Like> existingLike = likeRepository.findByMemberAndQuestion(member, question);
        if (existingLike.isPresent()) {
            likeRepository.delete(existingLike.get());
            question.setLikeCnt(question.getLikeCnt()-1);
        } else {
            Like like = new Like();
            like.setMember(member);
            like.setQuestion(question);
            likeRepository.save(like);
            question.setLikeCnt(question.getLikeCnt()+1);
        }

        questionRepository.save(question); // Like count 변경사항을 저장
    }
}

