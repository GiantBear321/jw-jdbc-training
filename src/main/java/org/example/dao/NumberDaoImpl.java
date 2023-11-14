package org.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.example.model.Number;
import org.example.util;

public class NumberDaoImpl implements NumberDao {

    @Override
    public Number get(Long id) {
        String sql = "SELECT * FROM test WHERE id = ?";
        try (Connection connection = util.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                double number = resultSet.getDouble("numbers");
                String description = resultSet.getString("description");

                Number number1 = new Number();
                number1.setNumber(number);
                number1.setId(id);
                number1.setDescription(description);
                return number1;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public Number save(Number number) {
        String sql = "INSERT INTO test (numbers, description) VALUES (?, ?)";
        try (Connection connection = util.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setDouble(1, number.getNumber());
            statement.setString(2, number.getDescription());

            int affectedRows = statement.executeUpdate();
            if (affectedRows < 1) {
                throw new RuntimeException("expected to insert 1 row but was 0!");
            }

            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                Long id = generatedKeys.getObject(1, Long.class);
                number.setId(id);
                return  number;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }
}
