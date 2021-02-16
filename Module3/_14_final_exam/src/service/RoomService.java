package service;

import model.Room;

import java.sql.SQLException;
import java.util.List;

public interface RoomService {
    List<Room> findAll();
    Room findById(int id);
    void save(Room room);
    List<Room> search(String searchName);
}
