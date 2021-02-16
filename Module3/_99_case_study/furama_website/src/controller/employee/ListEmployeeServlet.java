package controller.employee;

import model.Employee;
import model.dto.EmployeeDTO;
import service.employee.EmployeeService;
import service.employee.dto.EmployeeDTOService;
import service.employee.dto.impl.EmployeeDTOServiceImpl;
import service.employee.impl.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ListEmployeeServlet", urlPatterns = "/employee-list")
public class ListEmployeeServlet extends HttpServlet {
    private EmployeeDTOService employeeDTOService = new EmployeeDTOServiceImpl();
    private EmployeeService employeeService = new EmployeeServiceImpl();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<EmployeeDTO> employeeDTOList = employeeDTOService.findAll();
        int page = Integer.parseInt(request.getParameter("page"));
        int rowsPerPage = 5;
        int numPages = 0;
        if ((employeeDTOList.size() % rowsPerPage) == 0){
            numPages = employeeDTOList.size() / rowsPerPage;
        } else {
            numPages = employeeDTOList.size() / rowsPerPage + 1;
        }
        List<EmployeeDTO> employeeDTOPage = employeeDTOService.selectEmployeePage(page, rowsPerPage, employeeDTOList);
        HttpSession session = request.getSession();
        String signInUser = (String) session.getAttribute("signInUser");
        if (page > 1) {
            request.setAttribute("previousPage", "employee-list?page=" + (page - 1));
        }
        if (page < numPages) {
            request.setAttribute("nextPage", "employee-list?page=" + (page + 1));
        }
        request.setAttribute("page", page);
        request.setAttribute("numPages", numPages);
        request.setAttribute("signInUser", signInUser);
        request.setAttribute("employeeList", employeeDTOPage);
        request.getRequestDispatcher("jsp/employee/employeeList.jsp").forward(request, response);
    }
}
