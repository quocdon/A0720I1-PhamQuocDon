package dao.employee.impl;

import dao.employee.PositionDAO;
import model.Position;
import utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PositionDAOImpl implements PositionDAO {
    private static final String SELECT_ALL = "Select * from position";
    private static final String SELECT_BY_ID = "Select * from position where position_id = ?";

    @Override
    public List<Position> selectAll() throws SQLException {
        List<Position> positionList = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            int id = resultSet.getInt("position_id");
            String name = resultSet.getString("position_name");
            Position position = new Position(id, name);
            positionList.add(position);
        }
        return positionList;
    }

    @Override
    public Position selectPositionById(int id) throws SQLException {
        Position position = null;
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
            String name = resultSet.getString("position_name");
            position = new Position(id, name);
            return position;
        }
        return position;
    }
}
