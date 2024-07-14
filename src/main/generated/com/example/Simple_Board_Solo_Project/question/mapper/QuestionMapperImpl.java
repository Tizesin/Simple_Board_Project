package com.example.Simple_Board_Solo_Project.question.mapper;

import com.example.Simple_Board_Solo_Project.question.dto.QuestionDto;
import com.example.Simple_Board_Solo_Project.question.entity.Question;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-14T17:22:43+0900",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 11.0.23 (Azul Systems, Inc.)"
)
@Component
public class QuestionMapperImpl implements QuestionMapper {

    @Override
    public Question questionDtoPatchToQuestion(QuestionDto.Patch requestBody) {
        if ( requestBody == null ) {
            return null;
        }

        Question question = new Question();

        question.setQuestionId( requestBody.getQuestionId() );
        question.setTitle( requestBody.getTitle() );
        question.setContent( requestBody.getContent() );
        question.setQuestionType( requestBody.getQuestionType() );

        return question;
    }

    @Override
    public QuestionDto.Response questionToQuestionDtoResponse(Question question) {
        if ( question == null ) {
            return null;
        }

        QuestionDto.Response response = new QuestionDto.Response();

        response.setTitle( question.getTitle() );
        response.setContent( question.getContent() );
        if ( question.getQuestionType() != null ) {
            response.setQuestionType( question.getQuestionType().name() );
        }
        if ( question.getQuestionStatus() != null ) {
            response.setQuestionStatus( question.getQuestionStatus().name() );
        }
        response.setAnswer( question.getAnswer() );

        return response;
    }
}
