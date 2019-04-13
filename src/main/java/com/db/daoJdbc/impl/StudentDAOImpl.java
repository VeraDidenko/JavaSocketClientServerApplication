package com.db.daoJdbc.impl;

import com.db.ConnectionToDB;
import com.db.DAOException;
import com.db.daoJdbc.StudentDAO;
import com.db.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDAOImpl implements StudentDAO {
    public Student save(Student student) {

        String fio = student.getFio();
        Integer course = student.getCourse();

        String sql = "INSERT INTO student (fio, course) VALUES (?,?);";

        Map<Object, Class> parametersMap = new HashMap<>();
        parametersMap.put(fio, String.class);
        parametersMap.put(course, Integer.class);

        Integer id = BasicDAOImpl.save(sql, parametersMap);
        student.setId(id);

        return student;
    }

    public void update(Student student) {

        Integer id = student.getId();
        String fio = student.getFio();
        Integer course = student.getCourse();


        String sql = "UPDATE student SET fio=?, course=? WHERE id =?;";

        Map<Object, Class> parametersMap = new HashMap<>();
        parametersMap.put(fio, String.class);
        parametersMap.put(course, Integer.class);
        parametersMap.put(id, Integer.class);

        BasicDAOImpl.update(sql, parametersMap);

    }

    public Student get(Integer id) {

        Student student = null;
        String sql = "SELECT * FROM student WHERE id=? ";

        try (Connection connection = ConnectionToDB.getConnectionToDB();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                student = new Student(resultSet.getInt("id"), resultSet.getString("fio"), resultSet.getInt("course"));
            }

        } catch (SQLException | DAOException e) {
            e.printStackTrace();
        }


        return student;
    }

    @Override
    public Student getByName(String name) {
        Student student = null;
        String sql = "SELECT * FROM student WHERE fio=? ";

        try (Connection connection = ConnectionToDB.getConnectionToDB();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, name);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                student = new Student(resultSet.getInt("id"), resultSet.getString("fio"), resultSet.getInt("course"));
            }

        } catch (SQLException | DAOException e) {
            e.printStackTrace();
        }


        return student;
    }

    public void delete(Integer id) {

        String sql = "DELETE FROM student WHERE id=? ";
        BasicDAOImpl.delete(sql, id);

    }

    @Override
    public List<Student> getAllStudents() {

        String sql = "SELECT * FROM student";
        List<Student> students = new ArrayList<>();


        try (Connection connection = ConnectionToDB.getConnectionToDB();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Student student = new Student(resultSet.getInt("id"), resultSet.getString("fio"), resultSet.getInt("course"));
                students.add(student);
            }

        } catch (SQLException | DAOException e) {
            e.printStackTrace();
        }

        return students;
    }
}
