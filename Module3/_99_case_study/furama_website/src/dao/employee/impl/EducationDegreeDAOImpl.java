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
    private static final String SELECT_ALL_EDUCATION = "select * from education_degree";
    private static final String SELECT_EDUCATION_BY_ID = "select * from education_degree where education_degree_id = ?";

    @Override
    public List<EducationDegree> selectAll() throws SQLException {
        List<EducationDegree> educationDegreeList = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EDUCATION);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
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
        List<EducationDegree> educationDegreeList = this.selectAll();
        if (educationDegreeList.size() > 0){
            for (EducationDegree educationDegree : educationDegreeList){
                if (educationDegree.getId() == id){
                    return educationDegree;
                }
            }
        }
        return null;
    }
}
