package com.example.Simple_Board_Solo_Project.question.mapper;

import com.example.Simple_Board_Solo_Project.question.dto.QuestionDto;
import com.example.Simple_Board_Solo_Project.question.entity.Question;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface QuestionMapper {
    Question questionDtoPostToquestion(QuestionDto.Post requestBody);
    QuestionDto.Response questionToQuestionDtoResponse(Question question);
//    QuestionPost questionToQuestionPatch(QuestionPostDto.Patch requestBody);
}
