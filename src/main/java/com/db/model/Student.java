package com.db.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "student")
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "fio")
    private String fio;

    @Column(name = "course")
    private Integer course;

    public Student() {
    }

    public Student(String fio, Integer course) {
        this.fio = fio;
        this.course = course;
    }

    public Student(Integer id, String fio, Integer course) {
        this.id = id;
        this.fio = fio;
        this.course = course;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                ", Name:" + fio +
                ", Course:" + course;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public Integer getCourse() {
        return course;
    }

    public void setCourse(Integer course) {
        this.course = course;
    }
}
