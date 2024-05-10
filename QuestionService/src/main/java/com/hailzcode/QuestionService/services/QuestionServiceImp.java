package com.hailzcode.QuestionService.services;

import com.hailzcode.QuestionService.entities.Question;
import com.hailzcode.QuestionService.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImp implements QuestionService{

    @Autowired
    private QuestionRepository questionRepository;
    @Override
    public Question addQuestion(Question question) {
        return questionRepository.save(question);

    }

    @Override
    public List<Question> getAll() {
        return questionRepository.findAll();
    }

    @Override
    public Question getQuestionById(Long id) {
        return questionRepository.findById(id).orElseThrow(()-> new RuntimeException("Question not found"));
    }


    @Override
    public List<Question> getQuestionsOfQuiz(Long quizId) {
        return questionRepository.findByQuizId(quizId);
    }

    @Override
    public String updateQuestion(Question question) {
        questionRepository.save(question);
        return "Question Update Successfully";
    }

    @Override
    public String deleteQuestionById(long questionId) {
        if(questionRepository.existsById(questionId)){
            questionRepository.deleteById(questionId);
            return "questio with id " +questionId + "deleted successfully";
        }else {
            return "no record found";
        }
    }
}
