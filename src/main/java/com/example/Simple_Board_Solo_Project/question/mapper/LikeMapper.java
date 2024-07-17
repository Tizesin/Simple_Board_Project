package com.example.Simple_Board_Solo_Project.question.mapper;

import com.example.Simple_Board_Solo_Project.question.dto.LikeDto;
import com.example.Simple_Board_Solo_Project.question.entity.Like;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LikeMapper {
    Like likePostDtoToLike(LikeDto.Post requestBody);
}
