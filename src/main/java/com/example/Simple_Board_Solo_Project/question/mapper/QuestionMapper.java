package com.example.Simple_Board_Solo_Project.question.mapper;

import com.example.Simple_Board_Solo_Project.member.entity.Member;
import com.example.Simple_Board_Solo_Project.question.dto.QuestionDto;
import com.example.Simple_Board_Solo_Project.question.entity.Question;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.Simple_Board_Solo_Project.question.entity.Question.QuestionStatus.*;

@Mapper(componentModel = "spring")
public interface QuestionMapper {
    default Question questionDtoPostToQuestion(QuestionDto.Post requestBody){
        Member member = new Member();
        Question question = new Question();
        member.setMemberId(requestBody.getMemberId());
        question.setContent(requestBody.getContent());
        question.setTitle(requestBody.getTitle());
        question.setQuestionType(requestBody.getQuestionType());
        question.setMember(member);
        return question;
    }
//    QuestionMapper INSTANCE = Mappers.getMapper(QuestionMapper.class);

//    @Mapping(source = "memberId", target = "member.memberId")
//    Question questionDtoPostToQuestion(QuestionDto.Post requestBody);

    Question questionDtoPatchToQuestion(QuestionDto.Patch requestBody);
    QuestionDto.Response questionToQuestionDtoResponse(Question question);

    default List<QuestionDto.Response> questionToQuestionDtoResponses(List<Question> questions) {
        return questions
                .stream()
                .filter(status -> !status.getQuestionStatus().equals(QUESTION_DELETED))
                .filter(status -> !status.getQuestionStatus().equals(QUESTION_DEACTIVED))
                .map(question -> QuestionDto.Response
                        .builder()
                        .title(question.getTitle())
                        .content(question.getContent())
                        .questionType(question.getQuestionType().getTypeDescription())
                        .questionStatus(question.getQuestionStatus().getStatusDescription())
                        .answer(question.getAnswer())
                        .viewCnt(question.getViewCnt())
                        .build())
                .collect(Collectors.toList());

    }
}
