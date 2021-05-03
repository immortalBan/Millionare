package Millionare.Millionare.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Data
@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "users",uniqueConstraints = {@UniqueConstraint(columnNames={"id"})})
public class User {

    public User(String login, String name, String password, LocalDate birthday){
        this.login = login;
        this.name = name;
        this.password = password;
        this.birthday = birthday;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "login", length = 128, nullable = false)
    private String login;

    @Column(name = "name", length = 128, nullable = false)
    private String name;

    @Column(name = "password", length = 128, nullable = false)
    private String password;

    @Column(name="birthday",length = 60,nullable = false)
    private LocalDate birthday;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "time_created")
    private Date timeCreated;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                '}';
    }

}
