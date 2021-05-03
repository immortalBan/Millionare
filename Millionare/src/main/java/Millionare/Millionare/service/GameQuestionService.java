package Millionare.Millionare.service;

import Millionare.Millionare.entity.GameQuestion;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GameQuestionService {
    GameQuestion create(GameQuestion gameQuestion);

    List<GameQuestion> readAll();

    GameQuestion read(Long id);

    boolean update(GameQuestion gameQuestion, Long id);

    boolean delete(Long id);
}
