package Millionare.Millionare.serviceImpl;

import Millionare.Millionare.entity.Game;
import Millionare.Millionare.repo.GameRepo;
import Millionare.Millionare.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServiceImpl implements GameService {
    @Autowired
    private GameRepo gameRepo;

    @Override
    public Game create(Game game) {
        return gameRepo.save(game);
    }

    @Override
    public List<Game> readAll() {
        return gameRepo.findAll();
    }

    @Override
    public Game read(Long id) {
        return gameRepo.findById(id).orElse(null);
    }

    @Override
    public boolean update(Game game, Long id) {
        if (read(id) != null){
            Game newGame = new Game();
            newGame.setId(id);
            System.out.println(game.getPoints());
            newGame.setPoints(game.getPoints());
            newGame.setTimeCreated(read(id).getTimeCreated());

            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean delete(Long id) {
        if (read(id) != null) {
            gameRepo.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
