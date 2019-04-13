package com.db.daoJdbc.impl;

import com.db.ConnectionToDB;
import com.db.DAOException;
import com.db.daoJdbc.DisciplineDAO;
import com.db.model.Discipline;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class DisciplineDAOImpl implements DisciplineDAO {
    public Discipline save(Discipline discipline) {

        String name = discipline.getName();
        Integer credits = discipline.getCredits();

        String sql = "INSERT INTO disciplines (name, credits) VALUES (?,?);";


        Map<Object, Class> parametersMap = new HashMap<>();
        parametersMap.put(name, String.class);
        parametersMap.put(credits, Integer.class);

        Integer id = BasicDAOImpl.save(sql, parametersMap);
        discipline.setId(id);

        return discipline;
    }

    public void update(Discipline discipline) {

        Integer id = discipline.getId();
        String name = discipline.getName();
        Integer credits = discipline.getCredits();


        String sql = "UPDATE disciplines SET name=?, credits=? WHERE id =?;";

        Map<Object, Class> parametersMap = new HashMap<>();
        parametersMap.put(name, String.class);
        parametersMap.put(credits, Integer.class);
        parametersMap.put(id, Integer.class);

        BasicDAOImpl.update(sql, parametersMap);

    }

    public Discipline get(Integer id) {
        Discipline discipline = null;
        String sql = "SELECT * FROM disciplines WHERE id=? ";

        try (Connection connection = ConnectionToDB.getConnectionToDB();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                discipline = new Discipline(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getInt("credits"));
            }

        } catch (SQLException | DAOException e) {
            e.printStackTrace();
        }


        return discipline;
    }

    public void delete(Integer id) {
        String sql = "DELETE FROM disciplines WHERE id=? ";
        BasicDAOImpl.delete(sql, id);
    }
}
