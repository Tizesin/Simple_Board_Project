package com.example.Simple_Board_Solo_Project.answer.mapper;

import com.example.Simple_Board_Solo_Project.answer.entity.Answer;
import com.example.Simple_Board_Solo_Project.answer.dto.AnswerDto;
import com.example.Simple_Board_Solo_Project.member.dto.MemberDto;
import com.example.Simple_Board_Solo_Project.question.dto.QuestionDto;
import com.example.Simple_Board_Solo_Project.question.entity.Question;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring")
public interface AnswerMapper {
    default Answer answerPostToAnswer(AnswerDto.Post requestBody) {
        Question question = new Question();
        Answer answer = new Answer();
        question.setQuestionId(requestBody.getQuestionId());
        answer.setQuestion(question);
        answer.setContent(requestBody.getContent());
        answer.setTitle(requestBody.getTitle());
        return answer;
    }
    Answer answerPatchToAnswer(AnswerDto.Patch requestBody);
    AnswerDto.Response answerToAnswerResponse(Answer answer);
//    List<MemberDto.Response> membersToMemberResponses(List<Member> members);
}
