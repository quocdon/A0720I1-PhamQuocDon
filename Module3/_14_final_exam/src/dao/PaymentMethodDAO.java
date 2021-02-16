package dao;

import model.PaymentMethod;

import java.sql.SQLException;
import java.util.List;

public interface PaymentMethodDAO {
    List<PaymentMethod> selectAll() throws SQLException;
}
