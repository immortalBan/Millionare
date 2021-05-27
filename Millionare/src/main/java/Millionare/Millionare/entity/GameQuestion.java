package Millionare.Millionare.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "game_questions")
public class GameQuestion {

    public GameQuestion(Long gameId, Long questionId){
        this.gameId = gameId;
        this.questionId = questionId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private Long gameId;

    private Long questionId;
}
