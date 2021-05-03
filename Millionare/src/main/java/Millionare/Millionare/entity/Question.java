package Millionare.Millionare.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "questions",uniqueConstraints = {@UniqueConstraint(columnNames={"id"})})
public class Question {

    public Question(Long level, String text, String firstAnswer, String secondAnswer, String thirdAnswer, String fourthAnswer, Long correctAnswer){
        this.level = level;
        this.text = text;
        this.firstAnswer = firstAnswer;
        this.secondAnswer = secondAnswer;
        this.thirdAnswer = thirdAnswer;
        this.fourthAnswer = fourthAnswer;
        this.correctAnswer = correctAnswer;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "level", nullable = false)
    private Long level;

    @Column(name = "text", length = 256, nullable = false)
    private String text;

    @Column(name = "first_answer", length = 128, nullable = false)
    private String firstAnswer;

    @Column(name = "second_answer", length = 128, nullable = false)
    private String secondAnswer;

    @Column(name = "third_answer", length = 128, nullable = false)
    private String thirdAnswer;

    @Column(name = "fourth_answer", length = 128, nullable = false)
    private String fourthAnswer;

    @Column(name = "correct_answer", nullable = false)
    private Long correctAnswer;

}
