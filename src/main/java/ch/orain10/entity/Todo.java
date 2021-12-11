package ch.orain10.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "t_todos")
public class Todo extends PanacheEntity {

    public boolean done;
    @Column(name = "text")
    public String text;
    @Column(name = "category")
    public String category;
    @Column(name = "due_date")
    public LocalDate dueDate;

    @ManyToOne
    @JoinColumn(name = "userid_fk")
    public User user;

}
