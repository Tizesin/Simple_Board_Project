package com.example.Simple_Board_Solo_Project.answer.mapper;

import com.example.Simple_Board_Solo_Project.answer.entity.Answer;
import com.example.Simple_Board_Solo_Project.answer.dto.AnswerDto;
import com.example.Simple_Board_Solo_Project.member.dto.MemberDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AnswerMapper {
    Answer answerPostToAnswer(AnswerDto.Post requestBody);
    Answer answerPatchToAnswer(AnswerDto.Patch requestBody);
    AnswerDto.Response answerToAnswerResponse(Answer answer);
//    List<MemberDto.Response> membersToMemberResponses(List<Member> members);
}
