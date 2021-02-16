package controller.employee;

import model.Employee;
import service.employee.EmployeeService;
import service.employee.UserService;
import service.employee.impl.EmployeeServiceImpl;
import service.employee.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteEmployeeServlet", urlPatterns = "/employee-remove")
public class DeleteEmployeeServlet extends HttpServlet {
    private EmployeeService employeeService = new EmployeeServiceImpl();
    private UserService userService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee employee = employeeService.getById(id);
        userService.delete(employee.getUsername());
        response.sendRedirect("employee-list?page=1");
    }
}
