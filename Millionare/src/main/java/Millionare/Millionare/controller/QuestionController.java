package Millionare.Millionare.controller;

import Millionare.Millionare.entity.Question;
import Millionare.Millionare.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuestionController {
    private final QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService){
        this.questionService = questionService;
    }

    @PostMapping("/questions")
    Question newQuestion(@RequestBody Question newQuestion){
        System.out.println(newQuestion);
        return questionService.create(newQuestion);
    }

    @GetMapping(value = "/questions")
    public ResponseEntity<List<Question>> readQuestions() {
        final List<Question> questions = questionService.readAll();

        return questions != null && !questions.isEmpty()
                ? new ResponseEntity<>(questions, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/questions/{id}")
    public ResponseEntity<Question> readQuestion(@PathVariable(name = "id") Long id) {
        final Question question = questionService.read(id);

        return question != null
                ? new ResponseEntity<>(question, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/questions/{id}")
    public ResponseEntity<?> updateQuestion(@RequestBody Question question, @PathVariable(name = "id") Long id) {
        if (questionService.update(question, id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/questions/{id}")
    public ResponseEntity<?> deleteQuestion(@PathVariable(name = "id") Long id) {
        if (questionService.read(id) != null) {
            questionService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
