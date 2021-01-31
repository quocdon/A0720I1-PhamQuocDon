package service.service;

import model.Service;
import model.ServiceType;

import java.util.List;

public interface ServiceTypeService {
    List<ServiceType> findAll();
    ServiceType getServiceTypeById(int id);
}
