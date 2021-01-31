package service.contract;


import model.AttachService;

import java.util.List;

public interface AttachServiceService {
    List<AttachService> findAll();
    AttachService getRentTypeById(int id);
}
