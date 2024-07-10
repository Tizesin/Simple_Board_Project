package com.example.member.mapper;

import com.example.member.dto.MemberDto;
import com.example.member.entity.Member;

public interface MemberMapper {
    Member memberPostToMember(MemberDto.Post requestBody);
    Member memberPatchToMember(MemberDto.Patch requestBody);
//    MemberDto.Response memberToMemberResponse(Member member);
//    List<MemberDto.Response> membersToMemberResponses(List<Member> members);
}
