package dao.impl;

import dao.PaymentMethodDAO;
import model.PaymentMethod;
import utils.DBConnection;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaymentMethodDAOImpl implements PaymentMethodDAO {
    private static final String SELECT_ALL = "Select * from payment";
    @Override
    public List<PaymentMethod> selectAll() throws SQLException {
        List<PaymentMethod> methodList = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            String paymentMethod = resultSet.getString("method");
            methodList.add(new PaymentMethod(paymentMethod));
        }
        return methodList;
    }
}
