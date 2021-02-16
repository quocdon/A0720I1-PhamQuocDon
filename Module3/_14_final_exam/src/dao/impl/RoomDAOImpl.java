package dao.impl;

import dao.RoomDAO;
import model.Room;
import utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomDAOImpl implements RoomDAO {
    private static final String SELECT_ALL = "Select * from room";
    private static final String SELECT_BY_ID = "Select * from room where id = ?";
    private static final String INSERT_ROOM = "insert into room(name, phone, rent_date, payment_method, remark) values(?,?,?,?,?)";
    private static final String DELETE_ROOM = "delete from room where id = ?";
    @Override
    public List<Room> selectAll() throws SQLException {
        List<Room> roomList = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String phone = resultSet.getString("phone");
            String rentDate = resultSet.getString("rent_date");
            String paymentMethod = resultSet.getString("payment_method");
            String remark = resultSet.getString("remark");
            roomList.add(new Room(id, name, phone, rentDate, paymentMethod, remark));
        }
        return roomList;
    }

    @Override
    public Room selectById(int id) throws SQLException {
        List<Room> roomList = this.selectAll();
        for (Room room : roomList){
            if (room.getId() == id){
                return room;
            }
        }
        return null;
    }

    @Override
    public void insertRoom(Room room) throws SQLException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ROOM);
        preparedStatement.setString(1, room.getRenterName());
        preparedStatement.setString(2, room.getPhone());
        preparedStatement.setString(3, room.getRentDate());
        preparedStatement.setString(4, room.getPaymentMethod());
        preparedStatement.setString(5, room.getRemark());
        preparedStatement.executeUpdate();
    }

    @Override
    public List<Room> search(String searchName) {
        return null;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ROOM);
        preparedStatement.setInt(1, id);
        return preparedStatement.executeUpdate() > 0;
    }
}
