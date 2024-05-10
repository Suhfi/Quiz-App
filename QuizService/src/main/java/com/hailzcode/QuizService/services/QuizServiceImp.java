package com.hailzcode.QuizService.services;

import com.hailzcode.QuizService.client.QuestionClient;
import com.hailzcode.QuizService.entities.Quiz;
import com.hailzcode.QuizService.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizServiceImp implements QuizService{

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private QuestionClient questionClient;
    @Override
    public String addQuiz(Quiz quiz) {
        quizRepository.save(quiz);
        return "Quiz Added Successfully";
    }

    @Override
    public List<Quiz> getAllQuiz() {
        List<Quiz> allQuiz = quizRepository.findAll();
        List<Quiz> newQuizList = allQuiz.stream().map(quiz -> {
            quiz.setQuestions(questionClient.getQuestionsOfQuiz(quiz.getId()));
            return quiz;
        }).collect(Collectors.toList());

        return newQuizList;
    }

    @Override
    public Quiz getQuizById(Long id) {
        Quiz quizById = quizRepository.findById(id).orElseThrow(()-> new RuntimeException("Quiz not Found"));
        quizById.setQuestions(questionClient.getQuestionsOfQuiz(quizById.getId()));
        return quizById;
    }

    @Override
    public String updateQuiz(Quiz quiz) {
        quizRepository.save(quiz);
        return "Quiz updated Successfully";
    }

    @Override
    public String deleteQuizById(long id) {
        if(quizRepository.existsById(id)){
            quizRepository.deleteById(id);
            return "Quiz deleted Successfully";
        } else {
          return   "No Record Found";
        }
    }
}
