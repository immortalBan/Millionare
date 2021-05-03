package Millionare.Millionare.repo;

import Millionare.Millionare.entity.GameQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameQuestionRepo extends JpaRepository<GameQuestion, Long> {

}
