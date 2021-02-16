package controller.customer;

import common.Validate;
import model.Customer;
import model.CustomerType;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customer-create")
public class CustomerCreateServlet extends HttpServlet {
    private CustomerService customerService = new CustomerServiceImpl();
    private CustomerTypeService customerTypeService = new CustomerTypeServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Validate emailValidate = new Validate("^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$");
        Validate phoneValidate = new Validate("^09[0-1]\\d{7}$|^\\(84\\)\\+9[0-1]\\d{7}$");
        Validate idCardValidate = new Validate("^\\d{9}$|^\\d{12}$");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Customer customer = new Customer();
        int customerTypeId = Integer.parseInt(request.getParameter("customerType"));
        customer.setCustomerTypeId(customerTypeId);
        String name = request.getParameter("name");
        customer.setName(name);
        Date birthday = null;
        String birthdayInput = request.getParameter("birthday");
        try {
            birthday = dateFormat.parse(birthdayInput);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        customer.setBirthday(birthday);
        String gender = request.getParameter("gender");
        customer.setGender(gender);
        String idCard = request.getParameter("idCard");
        if (idCardValidate.checkRegex(idCard)){
            customer.setIdCard(idCard);
        } else {
            request.setAttribute("idCardFlag", "CMND có 9 hoặc 12 số" );
        }
        String phone = request.getParameter("phone");
        if (phoneValidate.checkRegex(phone)){
            customer.setPhone(phone);
        } else {
            request.setAttribute("phoneFlag", "SĐT theo định dạng 090xxxxxxx-091xxxxxxx-84+90xxxxxxx-(84)91xxxxxxx");
        }
        String email = request.getParameter("email");
        if (emailValidate.checkRegex(email)){
            customer.setEmail(email);
        } else {
            request.setAttribute("emailFlag", "Email đúng định dạng sample@codegym.com");
        }
        String address = request.getParameter("address");
        customer.setAddress(address);
        if (!idCardValidate.checkRegex(idCard) || !phoneValidate.checkRegex(phone) || !emailValidate.checkRegex(email)){
            request.setAttribute("customer", customer);
            this.doGet(request, response);
        } else {
            customer.setId(customerService.generateId());
            customerService.save(customer);
            response.sendRedirect("customer-list");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<CustomerType> customerTypeList = customerTypeService.findAll();
        String[] genderList = {"Nam", "Nữ", "Khác"};
        String urlPattern = "customer-create";
        HttpSession session = request.getSession();
        String signInUser = (String) session.getAttribute("signInUser");
        request.setAttribute("signInUser", signInUser);
        request.setAttribute("genderList", genderList);
        request.setAttribute("customerTypeList", customerTypeList);
        request.setAttribute("urlPattern", urlPattern);
        request.getRequestDispatcher("jsp/customer/customerUpdate.jsp").forward(request, response);
    }
}
