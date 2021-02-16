package service;

import model.PaymentMethod;

import java.sql.SQLException;
import java.util.List;

public interface PaymentMethodService {
    List<PaymentMethod> findAll();
}
