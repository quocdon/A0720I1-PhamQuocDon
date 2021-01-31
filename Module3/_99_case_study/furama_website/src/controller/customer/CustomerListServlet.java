package controller.customer;

import model.Customer;
import model.CustomerType;
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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerListServlet", urlPatterns = "/customer-list")
public class CustomerListServlet extends HttpServlet {
    private CustomerService customerService = new CustomerServiceImpl();
    private CustomerTypeService customerTypeService = new CustomerTypeServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = customerService.findAll();
        List<CustomerDTO> customerDTOList = new ArrayList<>();
        for (Customer customer: customerList){
            CustomerDTO customerDTO = new CustomerDTO();
            customerDTO.setId(customer.getId());
            customerDTO.setCustomerTypeId(customer.getCustomerTypeId());
            customerDTO.setCustomerTypeName(customerTypeService.getCustomerTypeById(customer.getCustomerTypeId()).getName());
            customerDTO.setName(customer.getName());
            customerDTO.setBirthday(customer.getBirthday());
            customerDTO.setGender(customer.getGender());
            customerDTO.setIdCard(customer.getIdCard());
            customerDTO.setPhone(customer.getPhone());
            customerDTO.setEmail(customer.getEmail());
            customerDTO.setAddress(customer.getAddress());
            customerDTOList.add(customerDTO);
        }
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        request.setAttribute("username", username);
        request.setAttribute("customerList", customerDTOList);
        request.getRequestDispatcher("jsp/customer/customerList.jsp").forward(request, response);
    }
}
