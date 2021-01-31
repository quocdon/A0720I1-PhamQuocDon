package dao.contract;

import model.AttachService;
import model.Department;

import java.sql.SQLException;
import java.util.List;

public interface AttachServiceDAO {
    List<AttachService> selectAll() throws SQLException;
    AttachService selectAttachServiceById(int id) throws SQLException;
}
