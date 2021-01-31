package controller.employee;

import model.*;
import service.employee.*;
import service.employee.impl.*;

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

@WebServlet(name = "CreateEmployeeServlet", urlPatterns = "/employee-create")
public class CreateEmployeeServlet extends HttpServlet {
    private PositionService positionService = new PositionServiceImpl();
    private DepartmentService departmentService = new DepartmentServiceImpl();
    private EducationDegreeService educationDegreeService = new EducationDegreeServiceImpl();
    private EmployeeService employeeService = new EmployeeServiceImpl();
    private UserService userService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String birthdayInput = request.getParameter("birthday");
        Date birthday = null;
        try {
            birthday = dateFormat.parse(birthdayInput);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String idCard = request.getParameter("idCard");
        double salary = Double.parseDouble(request.getParameter("salary"));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int position = Integer.parseInt(request.getParameter("position"));
        int educationDegree = Integer.parseInt(request.getParameter("educationDegree"));
        int department = Integer.parseInt(request.getParameter("department"));
        userService.save(new User(username, password));
        employeeService.save(new Employee(name, birthday, idCard, salary, phone, email, address, position, educationDegree, department, username));
        response.sendRedirect("employee-list");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Position> positionList = positionService.findAll();
        List<EducationDegree> educationDegreeList = educationDegreeService.findAll();
        List<Department> departmentList = departmentService.findAll();
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        request.setAttribute("username", username);
        request.setAttribute("positionList", positionList);
        request.setAttribute("educationDegreeList", educationDegreeList);
        request.setAttribute("departmentList", departmentList);
        request.getRequestDispatcher("jsp/employee/employeeCreate.jsp").forward(request, response);
    }
}
