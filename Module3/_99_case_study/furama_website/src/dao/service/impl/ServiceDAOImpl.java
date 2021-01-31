package dao.service.impl;

import dao.service.ServiceDAO;
import model.Service;
import utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceDAOImpl implements ServiceDAO {
    private static final String SELECT_ALL = "Select * from service";
    private static final String SELECT_BY_ID = "Select * from service where service_id = ?";
    private static final String INSERT_SERVICE = "insert into service(service_id, service_name, service_area, service_cost, service_max_people, rent_type_id, service_type_id) values(?,?,?,?,?,?,?)";
    private static final String DELETE_SERVICE = "delete from service where service_id = ?";
    private static final String UPDATE_SERVICE = "update service set service_name=?, service_area=?, service_cost=?, service_max_people=?, rent_type_id=?, service_type_id=? where service_id = ?";
    @Override
    public List<Service> selectAll() throws SQLException {
        List<Service> serviceList = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            String id = resultSet.getString("service_id");
            String name = resultSet.getString("service_name");
            int area = resultSet.getInt("service_area");
            double cost = resultSet.getDouble("service_cost");
            int maxPeople = resultSet.getInt("service_max_people");
            int rentTypeId = resultSet.getInt("rent_type_id");
            int serviceTypeId = resultSet.getInt("service_type_id");
            serviceList.add(new Service(id, name, area, cost, maxPeople, rentTypeId, serviceTypeId));
        }
        return serviceList;
    }

    @Override
    public Service selectServiceById(String id) throws SQLException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID);
        preparedStatement.setString(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
            String name = resultSet.getString("service_name");
            int area = resultSet.getInt("service_area");
            double cost = resultSet.getDouble("service_cost");
            int maxPeople = resultSet.getInt("service_max_people");
            int rentTypeId = resultSet.getInt("rent_type_id");
            int serviceTypeId = resultSet.getInt("service_type_id");
            return new Service(id, name, area, cost, maxPeople, rentTypeId, serviceTypeId);
        }
        return null;
    }

    @Override
    public void insertService(Service service) throws SQLException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SERVICE);
        preparedStatement.setString(1,service.getId());
        preparedStatement.setString(2,service.getName());
        preparedStatement.setInt(3,service.getArea());
        preparedStatement.setDouble(4,service.getCost());
        preparedStatement.setInt(5,service.getArea());
        preparedStatement.setInt(6,service.getRentTypeId());
        preparedStatement.setInt(7,service.getServiceTypeId());
        preparedStatement.executeUpdate();
    }

    @Override
    public boolean deleteService(String id) throws SQLException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SERVICE);
        preparedStatement.setString(1, id);
        return preparedStatement.executeUpdate() > 0;
    }

    @Override
    public boolean updateService(Service service) throws SQLException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SERVICE);
        preparedStatement.setString(1,service.getName());
        preparedStatement.setInt(2,service.getArea());
        preparedStatement.setDouble(3,service.getCost());
        preparedStatement.setInt(4,service.getArea());
        preparedStatement.setInt(5,service.getRentTypeId());
        preparedStatement.setInt(6,service.getServiceTypeId());
        preparedStatement.setString(7,service.getId());
        return preparedStatement.executeUpdate() > 0;
    }

    @Override
    public List<Service> selectServiceByName(String name) throws SQLException {
        List<Service> serviceList = this.selectAll();
        List<Service> result = new ArrayList<>();
        for (Service service : serviceList){
            if (service.getName().contains(name)){
                result.add(service);
            }
        }
        return result;
    }
}
