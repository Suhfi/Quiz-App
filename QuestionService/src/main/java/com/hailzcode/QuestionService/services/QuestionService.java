package com.hailzcode.QuestionService.services;

import com.hailzcode.QuestionService.entities.Question;

import java.util.List;

public interface QuestionService {
    public Question addQuestion(Question question);
    public List<Question> getAll();
    public Question getQuestionById(Long id);

    List<Question> getQuestionsOfQuiz(Long quizId);
    public String updateQuestion(Question question);
    public String deleteQuestionById(long questionId);
}
