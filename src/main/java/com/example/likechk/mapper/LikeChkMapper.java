package com.example.likechk.mapper;

import com.example.likechk.dto.LikeChkDto;
import com.example.likechk.entity.LikeChk;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LikeChkMapper {
    LikeChk likeChkPostDtoToLikeChk(LikeChkDto.Post requestBody);
}
