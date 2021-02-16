package dao;

import model.Room;

import java.sql.SQLException;
import java.util.List;

public interface RoomDAO {
    List<Room> selectAll() throws SQLException;
    Room selectById(int id) throws SQLException;
    void insertRoom(Room room) throws SQLException;
    List<Room> search(String searchName);
    boolean delete(int id) throws SQLException;
}
