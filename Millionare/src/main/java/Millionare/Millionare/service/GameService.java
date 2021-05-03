package Millionare.Millionare.service;

import Millionare.Millionare.entity.Game;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GameService {

    Game create(Game game);

    List<Game> readAll();

    Game read(Long id);

    boolean update(Game game, Long id);

    boolean delete(Long id);
}
