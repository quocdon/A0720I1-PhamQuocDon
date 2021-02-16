package service.impl;

import dao.RoomDAO;
import dao.impl.RoomDAOImpl;
import model.Room;
import service.RoomService;

import java.sql.SQLException;
import java.util.List;

public class RoomServiceImpl implements RoomService {
    RoomDAO roomDAO = new RoomDAOImpl();
    @Override
    public List<Room> findAll() {
        try {
            return roomDAO.selectAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Room findById(int id) {
        List<Room> roomList = null;
        roomList = this.findAll();
        for (Room room: roomList){
            if (room.getId() == id){
                return room;
            }
        }
        return null;
    }

    @Override
    public void save(Room room) {
        try {
            roomDAO.insertRoom(room);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Room> search(String searchName) {
        return roomDAO.search(searchName);
    }
}
