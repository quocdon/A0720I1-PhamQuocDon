package dao.employee.impl;

import dao.employee.EducationDegreeDAO;
import model.EducationDegree;
import utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EducationDegreeDAOImpl implements EducationDegreeDAO {
    private static final String SELECT_ALL = "Select * from education_degree";
    private static final String SELECT_BY_ID = "Select * from education_degree where education_degree_id = ?";

    @Override
    public List<EducationDegree> selectAll() throws SQLException {
        List<EducationDegree> educationDegreeList = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            int id = resultSet.getInt("education_degree_id");
            String name = resultSet.getString("education_degree_name");
            EducationDegree educationDegree = new EducationDegree(id, name);
            educationDegreeList.add(educationDegree);
        }
        return educationDegreeList;
    }

    @Override
    public EducationDegree selectEducationDegreeById(int id) throws SQLException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
            String name = resultSet.getString("education_degree_name");
            return new EducationDegree(id, name);
        }
        return null;
    }
}
