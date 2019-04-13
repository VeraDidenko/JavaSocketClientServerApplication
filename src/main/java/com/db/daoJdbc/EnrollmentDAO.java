package com.db.daoJdbc;

import com.db.model.Enrollment;

import java.util.List;

public interface EnrollmentDAO {

    Enrollment save(Enrollment enrollment);
    void update(Enrollment enrollment);
    Enrollment get(Integer id);
    void delete(Integer id);
    List<Enrollment> getByStudentId(Integer studId);

}
