package com.example.Simple_Board_Solo_Project.question.mapper;

import com.example.Simple_Board_Solo_Project.member.entity.Member;
import com.example.Simple_Board_Solo_Project.question.dto.LikeDto;
import com.example.Simple_Board_Solo_Project.question.entity.Like;
import com.example.Simple_Board_Solo_Project.question.entity.Question;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LikeMapper {
    default Like likePostDtoToLike(LikeDto.Post requestBody){
        Member member = new Member();
        Question question = new Question();
        member.setMemberId(requestBody.getMemberId());
        question.setQuestionId(requestBody.getQuestionId());
        Like like = new Like();
        like.setQuestion(question);
        like.setMember(member);
        return like;
    }
}
