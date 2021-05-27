package Millionare.Millionare.serviceImpl;

import Millionare.Millionare.entity.GameQuestion;
import Millionare.Millionare.repo.GameQuestionRepo;
import Millionare.Millionare.service.GameQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameQuestionServiceImpl implements GameQuestionService {

    @Autowired
    private GameQuestionRepo gameQuestionRepo;

    @Override
    public GameQuestion create(GameQuestion gameQuestion) {
        return gameQuestionRepo.save(gameQuestion);
    }

    @Override
    public List<GameQuestion> readAll() {
        return gameQuestionRepo.findAll();
    }

    @Override
    public GameQuestion read(Long id) {
        return gameQuestionRepo.findById(id).orElse(null);
    }

    @Override
    public boolean update(GameQuestion gameQuestion, Long id) {
        if (read(id) != null) {
            GameQuestion newGameQuestion = new GameQuestion();
            newGameQuestion.setId(id);
            newGameQuestion.setGameId(gameQuestion.getGameId());
            newGameQuestion.setQuestionId(gameQuestion.getQuestionId());

            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean delete(Long id) {
        if (read(id) != null) {
            gameQuestionRepo.deleteById(id);

            return true;
        } else {
            return false;
        }
    }
}
