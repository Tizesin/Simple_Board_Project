package com.example.answer.mapper;

import com.example.answer.entity.Answer;
import com.example.Simple_Board_Solo_Project.member.dto.MemberDto;
import com.example.Simple_Board_Solo_Project.member.entity.Member;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AnswerMapper {
    Answer memberPostToMember(MemberDto.Post requestBody);
    Answer memberPatchToMember(MemberDto.Patch requestBody);
    MemberDto.Response memberToMemberResponse(Member member);
//    List<MemberDto.Response> membersToMemberResponses(List<Member> members);
}
