package service.service;

import model.RentType;

import java.util.List;

public interface RentTypeService {
    List<RentType> findAll();
    RentType getRentTypeById(int id);
}
