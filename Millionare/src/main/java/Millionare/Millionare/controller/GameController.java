package Millionare.Millionare.controller;

import Millionare.Millionare.entity.Game;
import Millionare.Millionare.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GameController {
    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService){
        this.gameService = gameService;
    }

    @PostMapping("/games")
    Game newGame(@RequestBody Game newGame){
        System.out.println(newGame);
        return gameService.create(newGame);
    }

    @GetMapping(value = "/games")
    public ResponseEntity<List<Game>> readGames() {
        final List<Game> games = gameService.readAll();

        return games != null && !games.isEmpty()
                ? new ResponseEntity<>(games, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/games/{id}")
    public ResponseEntity<Game> readGame(@PathVariable(name = "id") Long id) {
        final Game game = gameService.read(id);

        return game != null
                ? new ResponseEntity<>(game, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/games/{id}")
    public ResponseEntity<?> updateGame(@RequestBody Game game, @PathVariable(name = "id") Long id) {
        if (gameService.update(game, id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/games/{id}")
    public ResponseEntity<?> deleteGame(@PathVariable(name = "id") Long id) {
        if (gameService.read(id) != null) {
            gameService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
