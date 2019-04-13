package com.db.model;

import javax.persistence.*;

@Entity
@Table(name = "enrollment")
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "student_id")
    private Integer stud_id;

    @Column(name = "discipline_id")
    private Integer disc_id;

    @Column(name = "grade")
    private Integer grade;

    public Enrollment() {
    }

    public Enrollment(Integer stud_id, Integer disc_id, Integer grade) {
        this.stud_id = stud_id;
        this.disc_id = disc_id;
        this.grade = grade;
    }

    public Enrollment(Integer id, Integer stud_id, Integer disc_id, Integer grade) {
        this(stud_id, disc_id, grade);
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStud_id() {
        return stud_id;
    }

    public void setStud_id(Integer stud_id) {
        this.stud_id = stud_id;
    }

    public Integer getDisc_id() {
        return disc_id;
    }

    public void setDisc_id(Integer disc_id) {
        this.disc_id = disc_id;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }
}
