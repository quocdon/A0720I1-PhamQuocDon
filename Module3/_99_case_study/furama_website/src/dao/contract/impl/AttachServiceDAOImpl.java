package dao.contract.impl;

import dao.contract.AttachServiceDAO;
import model.AttachService;
import model.Service;
import utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AttachServiceDAOImpl implements AttachServiceDAO {
    private static final String SELECT_ALL = "Select * from attach_service";
    private static final String SELECT_BY_ID = "Select * from attach_service where attach_service_id = ?";
    @Override
    public List<AttachService> selectAll() throws SQLException {
        Connection connection = DBConnection.getConnection();
        List<AttachService> attachServiceList = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            int id = resultSet.getInt("attach_service_id");
            String name = resultSet.getString("attach_service_name");
            double cost = resultSet.getDouble("attach_service_cost");
            String unit = resultSet.getString("attach_service_unit");
            String status = resultSet.getString("attach_service_status");
            attachServiceList.add(new AttachService(id, name, cost, unit, status));
        }
        return attachServiceList;
    }

//    String id = resultSet.getString("service_id");
//    String name = resultSet.getString("service_name");
//    int area = resultSet.getInt("service_area");
//    double cost = resultSet.getDouble("service_cost");
//    int maxPeople = resultSet.getInt("max_people");
//    int rentTypeId = resultSet.getInt("rent_type_id");
//    int serviceTypeId = resultSet.getInt("service_type_id");
//    Service service = new Service(id, name, area, cost, maxPeople, rentTypeId, serviceTypeId);

    @Override
    public AttachService selectAttachServiceById(int id) throws SQLException {
        List<AttachService> attachServiceList = new ArrayList<>();
        for (AttachService attachService : attachServiceList){
            if (attachService.getId() == id){
                return attachService;
            }
        }
        return null;
    }
}
