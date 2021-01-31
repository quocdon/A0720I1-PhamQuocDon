package dao.service.impl;

import dao.service.RentTypeDAO;
import model.RentType;
import utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RentTypeDAOImpl implements RentTypeDAO {
    private static final String SELECT_ALL = "Select * from rent_type";
    private static final String SELECT_BY_ID = "Select * from rent_type where rent_type_id = ?";
    @Override
    public List<RentType> selectAll() throws SQLException {
        List<RentType> rentTypeList = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            int id = resultSet.getInt("rent_type_id");
            String name = resultSet.getString("rent_type_name");
            rentTypeList.add(new RentType(id, name));
        }
        return rentTypeList;
    }

    @Override
    public RentType selectById(int id) throws SQLException {
        List<RentType> rentTypeList = this.selectAll();
        for (RentType rentType : rentTypeList){
            if (rentType.getId() == id){
                return rentType;
            }
        }
        return null;
    }
}
