package com.hailzcode.QuestionService.controller;

import com.hailzcode.QuestionService.entities.Question;
import com.hailzcode.QuestionService.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @PostMapping
    public ResponseEntity<Question> addQuestion(@RequestBody Question question){
        Question add = questionService.addQuestion(question);
        return new ResponseEntity<>(add, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<String> updateQuestion(@RequestBody Question question){
        return new ResponseEntity<>(questionService.updateQuestion(question),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Question>> getAll(){
        List<Question> all = questionService.getAll();
        return new ResponseEntity<>(all,HttpStatus.OK);
    }

    @GetMapping("/{questionId}")
    public ResponseEntity<Question> getQuesById(@PathVariable Long questionId){
        Question getOne = questionService.getQuestionById(questionId);
        return new ResponseEntity<>(getOne,HttpStatus.OK);
    }

    @GetMapping("/quiz/{quizId}")
    public ResponseEntity<List<Question>> getQuestionsOfQuiz(@PathVariable Long quizId){
        List<Question> quesByQuizId = questionService.getQuestionsOfQuiz(quizId);
        return new ResponseEntity<>(quesByQuizId,HttpStatus.OK);
    }

    @DeleteMapping("/{questionId}")
    public ResponseEntity<String> deleteQuestion(@PathVariable long questionId){
        return new ResponseEntity<>(questionService.deleteQuestionById(questionId),HttpStatus.OK);
    }
}
