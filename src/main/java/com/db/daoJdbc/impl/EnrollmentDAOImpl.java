package com.db.daoJdbc.impl;

import com.db.ConnectionToDB;
import com.db.DAOException;
import com.db.daoJdbc.EnrollmentDAO;
import com.db.model.Enrollment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EnrollmentDAOImpl implements EnrollmentDAO {
    public Enrollment save(Enrollment enrollment) {


        Integer grade = enrollment.getGrade();
        Integer stud_id = enrollment.getStud_id();
        Integer disc_id =enrollment.getDisc_id();

        String sql = "INSERT INTO enrollment (grade, discipline_id, student_id) VALUES (?,?,?);";

        Map<Object, Class> parametersMap = new HashMap<>();
        parametersMap.put(grade, Integer.class);
        parametersMap.put(stud_id, Integer.class);
        parametersMap.put(disc_id, Integer.class);

        Integer id = BasicDAOImpl.save(sql, parametersMap);
        enrollment.setId(id);

        return enrollment;
    }

    public void update(Enrollment enrollment) {


        Integer grade = enrollment.getGrade();
        Integer stud_id = enrollment.getStud_id();
        Integer disc_id =enrollment.getDisc_id();
        Integer id = enrollment.getId();


        String sql = "UPDATE discipline SET grade=?, discipline_id=?, student_id=? WHERE id =?;";

        Map<Object, Class> parametersMap = new HashMap<>();
        parametersMap.put(grade, Integer.class);
        parametersMap.put(disc_id, Integer.class);
        parametersMap.put(stud_id, Integer.class);
        parametersMap.put(id, Integer.class);

        BasicDAOImpl.update(sql, parametersMap);

    }

    public Enrollment get(Integer id) {
        Enrollment enrollment = null;
        String sql = "SELECT * FROM discipline WHERE id=? ";

        try (Connection connection = ConnectionToDB.getConnectionToDB();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                enrollment = new Enrollment(resultSet.getInt("id"), resultSet.getInt("student_id"),resultSet.getInt("discipline_id"), resultSet.getInt("grade"));
            }

        } catch (SQLException | DAOException e) {
            e.printStackTrace();
        }


        return enrollment;
    }

    public void delete(Integer id) {
        String sql = "DELETE FROM enrollment WHERE id=? ";
        BasicDAOImpl.delete(sql, id);
    }

    @Override
    public List<Enrollment> getByStudentId(Integer studId) {

        String sql = "SELECT * FROM enrollment WHERE student_id=?";
        List<Enrollment> enrollments = new ArrayList<>();


        try (Connection connection = ConnectionToDB.getConnectionToDB();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1,studId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
              Enrollment  enrollment = new Enrollment(resultSet.getInt("id"), resultSet.getInt("student_id"),resultSet.getInt("discipline_id"), resultSet.getInt("grade"));

                enrollments.add(enrollment);
            }

        } catch (SQLException | DAOException e) {
            e.printStackTrace();
        }

        return enrollments;
    }
}
