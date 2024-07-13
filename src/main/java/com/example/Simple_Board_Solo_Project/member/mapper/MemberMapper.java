package com.example.Simple_Board_Solo_Project.member.mapper;

import com.example.Simple_Board_Solo_Project.member.dto.MemberDto;
import com.example.Simple_Board_Solo_Project.member.entity.Member;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MemberMapper {
    Member memberPostDToToMember(MemberDto.Post requestBody);
    Member memberPatchToMember(MemberDto.Patch requestBody);
    MemberDto.Response memberToMemberResponseDto(Member member);
}
