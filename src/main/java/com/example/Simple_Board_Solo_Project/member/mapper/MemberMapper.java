package com.example.Simple_Board_Solo_Project.member.mapper;

import com.example.Simple_Board_Solo_Project.member.dto.MemberDto;
import com.example.Simple_Board_Solo_Project.member.entity.Member;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MemberMapper {
    Member memberPostToMember(MemberDto.Post requestBody);
    Member memberPatchToMember(MemberDto.Patch requestBody);
    MemberDto.Response memberToMemberDtoResponse(Member member);
//    List<MemberDto.Response> membersToMemberResponses(List<Member> members);
}
