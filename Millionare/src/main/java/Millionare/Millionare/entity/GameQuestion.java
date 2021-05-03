package Millionare.Millionare.entity;

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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="game_id",nullable = false)
    private Game game;

    @ManyToOne
    @JoinColumn(name="question_id",nullable = false)
    private Question question;
}
