package com.hailzcode.QuizService.controller;

import com.hailzcode.QuizService.entities.Quiz;
import com.hailzcode.QuizService.services.QuizServiceImp;
import jakarta.ws.rs.PUT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizServiceImp quizServiceImp;

    @PostMapping
    public ResponseEntity<String> addQuiz(@RequestBody Quiz quiz){
        String add = quizServiceImp.addQuiz(quiz);
        return new ResponseEntity<>(add , HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<String> updateQuiz(@RequestBody Quiz quiz){
        String updateQuiz = quizServiceImp.addQuiz(quiz);
        return new ResponseEntity<>(updateQuiz , HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Quiz>> getAll(){
        List<Quiz> getAll = quizServiceImp.getAllQuiz();
        return new ResponseEntity<>(getAll,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Quiz> getById(@PathVariable Long id){
        Quiz getOne = quizServiceImp.getQuizById(id);
        return new ResponseEntity<>(getOne,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteQuizById(@PathVariable Long id){
        return new ResponseEntity<>(quizServiceImp.deleteQuizById(id),HttpStatus.OK);
    }
}
