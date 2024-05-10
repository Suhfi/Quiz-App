package com.hailzcode.QuizService.services;

import com.hailzcode.QuizService.entities.Quiz;

import java.util.List;

public interface QuizService {
    public String addQuiz(Quiz quiz);
    public List<Quiz> getAllQuiz();
    public Quiz getQuizById(Long id);
    public String updateQuiz(Quiz quiz);
    public String deleteQuizById(long id);
}
