package service.employee;

import model.Position;

import java.util.List;

public interface PositionService {
    List<Position> findAll();
    Position getPositionById(int id);
}
