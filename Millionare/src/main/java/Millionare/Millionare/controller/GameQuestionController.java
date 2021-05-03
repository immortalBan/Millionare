package Millionare.Millionare.controller;

import Millionare.Millionare.entity.GameQuestion;
import Millionare.Millionare.service.GameQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GameQuestionController {

    private final GameQuestionService gameQuestionService;

    @Autowired
    public GameQuestionController(GameQuestionService gameQuestionService){
        this.gameQuestionService = gameQuestionService;
    }

    @PostMapping("/game_questions")
    GameQuestion newGameQuestion(@RequestBody GameQuestion newGameQuestion){
        System.out.println(newGameQuestion);
        return gameQuestionService.create(newGameQuestion);
    }

    @GetMapping(value = "/game_questions")
    public ResponseEntity<List<GameQuestion>> readGameQuestions() {
        final List<GameQuestion> gameQuestions = gameQuestionService.readAll();

        return gameQuestions != null && !gameQuestions.isEmpty()
                ? new ResponseEntity<>(gameQuestions, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/game_questions/{id}")
    public ResponseEntity<GameQuestion> readGameQuestion(@PathVariable(name = "id") Long id) {
        final GameQuestion gameQuestion = gameQuestionService.read(id);

        return gameQuestion != null
                ? new ResponseEntity<>(gameQuestion, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/game_questions/{id}")
    public ResponseEntity<?> updateGameQuestion(@RequestBody GameQuestion gameQuestion, @PathVariable(name = "id") Long id) {
        if (gameQuestionService.update(gameQuestion, id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/game_questions/{id}")
    public ResponseEntity<?> deleteGameQuestion(@PathVariable(name = "id") Long id) {
        if (gameQuestionService.read(id) != null) {
            gameQuestionService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
