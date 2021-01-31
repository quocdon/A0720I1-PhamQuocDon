package service.service.impl;

import dao.service.ServiceDAO;
import dao.service.impl.ServiceDAOImpl;
import model.Contract;
import model.Service;
import service.IdComparator;
import service.service.ServiceService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ServiceServiceImpl implements ServiceService {
    ServiceDAO serviceDAO = new ServiceDAOImpl();

    @Override
    public List<Service> findAll() {
        try {
            return serviceDAO.selectAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Service getById(String id) {
        try {
            return serviceDAO.selectServiceById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(Service service) {
        try {
            serviceDAO.insertService(service);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean remove(String id) {
        try {
            return serviceDAO.deleteService(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Service service) {
        try {
            return serviceDAO.updateService(service);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Service> searchByName(String name) {
        try {
            return serviceDAO.selectServiceByName(name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String generateId() {
        List<String> idList = new ArrayList<>();
        List<Service> serviceList = new ArrayList<>();
        try {
            serviceList = serviceDAO.selectAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (serviceList.size() == 0){
            return "DV-0001";
        }

        for (Service service : serviceList){
            idList.add(service.getId());
        }

        IdComparator idComparator = new IdComparator();
        Collections.sort(idList, idComparator);
        String lastId = idList.get(idList.size()-1);
        String newId = "DV-".concat(String.format("%04d", Integer.parseInt(lastId.substring(3)) + 1));
        return newId;
    }
}
