package controller.customer;

import model.Customer;
import model.dto.CustomerDTO;
import service.customer.CustomerService;
import service.customer.CustomerTypeService;
import service.customer.impl.CustomerServiceImpl;
import service.customer.impl.CustomerTypeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "CustomerViewServlet", urlPatterns = "/customer-view")
public class CustomerViewServlet extends HttpServlet {
    CustomerService customerService = new CustomerServiceImpl();
    CustomerTypeService customerTypeService = new CustomerTypeServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Customer customer = customerService.getById(id);
        CustomerDTO customerDTO = new CustomerDTO(customer.getId(), customer.getCustomerTypeId(), customerTypeService.getCustomerTypeById(customer.getCustomerTypeId()).getName(), customer.getName(), customer.getBirthday(), customer.getGender(), customer.getIdCard(), customer.getPhone(), customer.getEmail(), customer.getAddress());
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        request.setAttribute("username", username);
        request.setAttribute("customer", customerDTO);
        request.getRequestDispatcher("jsp/customer/customerView.jsp").forward(request, response);
    }
}
