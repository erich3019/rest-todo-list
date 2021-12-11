package ch.orain10.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;

@Entity
@Table(name = "t_users")
public class User extends PanacheEntity {

    @Column(name = "first_name")
    public String firstName;
    @Column(name = "last_name")
    public String lastName;

}
