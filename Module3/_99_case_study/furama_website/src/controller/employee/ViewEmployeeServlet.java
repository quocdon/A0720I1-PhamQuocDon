package controller.employee;

import model.dto.EmployeeDTO;
import service.employee.dto.EmployeeDTOService;
import service.employee.dto.impl.EmployeeDTOServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ViewEmployeeServlet", urlPatterns = "/employee-view")
public class ViewEmployeeServlet extends HttpServlet {
    private EmployeeDTOService employeeDTOService = new EmployeeDTOServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        EmployeeDTO employeeDTO = employeeDTOService.getById(id);
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        request.setAttribute("username", username);
        request.setAttribute("employee", employeeDTO);
        request.getRequestDispatcher("jsp/employee/employeeView.jsp").forward(request, response);
    }
}
