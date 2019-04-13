package com.db.daoJdbc;

import com.db.model.Student;

import java.util.List;

public interface StudentDAO {

    Student save(Student student);
    void update(Student student);
    Student get(Integer id);
    Student getByName(String name);
    void delete(Integer id);
    List<Student> getAllStudents();

}
