package com.db.model;

import javax.persistence.*;

@Entity
@Table(name="disciplines")
public class Discipline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name = "credits")
    private Integer credits;

    public Discipline() {
    }

    public Discipline(String name, Integer credits) {
        this.name = name;
        this.credits = credits;
    }

    public Discipline(Integer id, String name, Integer credits) {
        this(name, credits);
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }
}
