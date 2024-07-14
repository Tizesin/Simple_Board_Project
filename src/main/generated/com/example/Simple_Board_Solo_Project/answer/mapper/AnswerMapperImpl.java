package com.example.Simple_Board_Solo_Project.answer.mapper;

import com.example.Simple_Board_Solo_Project.answer.dto.AnswerDto;
import com.example.Simple_Board_Solo_Project.answer.entity.Answer;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-14T17:22:43+0900",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 11.0.23 (Azul Systems, Inc.)"
)
@Component
public class AnswerMapperImpl implements AnswerMapper {

    @Override
    public Answer answerPatchToAnswer(AnswerDto.Patch requestBody) {
        if ( requestBody == null ) {
            return null;
        }

        Answer answer = new Answer();

        return answer;
    }

    @Override
    public AnswerDto.Response answerToAnswerResponse(Answer answer) {
        if ( answer == null ) {
            return null;
        }

        AnswerDto.Response response = new AnswerDto.Response();

        response.setAnswerId( answer.getAnswerId() );
        response.setTitle( answer.getTitle() );
        response.setContent( answer.getContent() );

        return response;
    }
}
