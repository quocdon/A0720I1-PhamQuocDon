package service.impl;

import dao.PaymentMethodDAO;
import dao.impl.PaymentMethodDAOImpl;
import model.PaymentMethod;
import service.PaymentMethodService;

import java.sql.SQLException;
import java.util.List;

public class PaymentMethodServiceImpl implements PaymentMethodService {
    PaymentMethodDAO paymentMethodDAO = new PaymentMethodDAOImpl();

    @Override
    public List<PaymentMethod> findAll() {
        try {
            return paymentMethodDAO.selectAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
