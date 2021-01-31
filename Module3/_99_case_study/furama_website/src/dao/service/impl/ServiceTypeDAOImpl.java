package dao.service.impl;

import com.mysql.cj.x.protobuf.MysqlxPrepare;
import dao.service.ServiceTypeDAO;
import model.ServiceType;
import utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceTypeDAOImpl implements ServiceTypeDAO {
    private static final String SELECT_ALL = "Select * from service_type";
    private static final String SELECT_BY_ID = "Select * from service_type where service_type_id = ?";
    @Override
    public List<ServiceType> selectAll() throws SQLException {
        List<ServiceType> serviceTypeList = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            int id = resultSet.getInt("service_type_id");
            String name = resultSet.getNString("service_type_name");
            serviceTypeList.add(new ServiceType(id, name));
        }
        return serviceTypeList;
    }

    @Override
    public ServiceType selectById(int id) throws SQLException {
        List<ServiceType> serviceTypeList = this.selectAll();
        for (ServiceType serviceType : serviceTypeList){
            if (serviceType.getId() == id){
                return serviceType;
            }
        }
        return null;
    }
}
