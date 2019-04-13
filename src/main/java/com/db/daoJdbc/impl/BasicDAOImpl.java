package com.db.daoJdbc.impl;

import com.db.ConnectionToDB;
import com.db.DAOException;

import java.sql.*;
import java.util.Map;

class BasicDAOImpl {

    static Integer save(String sql, Map<Object, Class> parametersToSave) {
        Integer id = null;
        try (Connection connection = ConnectionToDB.getConnectionToDB();
             PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {

            createStatement(parametersToSave, statement);

            statement.execute();
            ResultSet result = statement.getGeneratedKeys();

            if (result.next()) {
                id = result.getInt(1);
            }


        } catch (SQLException | DAOException e) {
            e.printStackTrace();
        }

        return id;
    }

    static void update(String sql, Map<Object, Class> parametersToSave) {

        try (Connection connection = ConnectionToDB.getConnectionToDB();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            createStatement(parametersToSave, statement);

            statement.executeUpdate();

        } catch (SQLException | DAOException e) {
            e.printStackTrace();
        }

    }

    private static void createStatement(Map<Object, Class> parametersToSave, PreparedStatement statement) {
        try {

            int i = 1;
            for (Map.Entry<Object, Class> parameters : parametersToSave.entrySet()) {
                Class classFromPar = parameters.getValue();
                if (classFromPar == String.class) {
                    statement.setString(i, (String) parameters.getKey());
                    i++;
                } else if (classFromPar == Integer.class) {
                    statement.setInt(i, (Integer) parameters.getKey());
                    i++;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void delete(String sql, Integer id) {

        try (Connection connection = ConnectionToDB.getConnectionToDB();
             PreparedStatement statement = connection.prepareStatement(sql);) {

            statement.setInt(1, id);

            statement.executeUpdate();

        } catch (SQLException | DAOException e) {
            e.printStackTrace();
        }

    }

}
