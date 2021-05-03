package Millionare.Millionare.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "games",uniqueConstraints = {@UniqueConstraint(columnNames={"id"})})
public class Game {

    public Game(Long points){
        this.points = points;
    }

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "time_created")
    private Date timeCreated;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "points", nullable = false)
    private Long points;

    @ManyToOne
    @JoinColumn(name="user_id",nullable = false)
    private User user;

}
