package controller.employee;

import model.Department;
import model.EducationDegree;
import model.Employee;
import model.Position;
import model.dto.EmployeeDTO;
import service.employee.DepartmentService;
import service.employee.EducationDegreeService;
import service.employee.EmployeeService;
import service.employee.PositionService;
import service.employee.dto.EmployeeDTOService;
import service.employee.dto.impl.EmployeeDTOServiceImpl;
import service.employee.impl.DepartmentServiceImpl;
import service.employee.impl.EducationDegreeServiceImpl;
import service.employee.impl.EmployeeServiceImpl;
import service.employee.impl.PositionServiceImpl;

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

@WebServlet(name = "EditEmployeeServlet", urlPatterns = "/employee-edit")
public class EditEmployeeServlet extends HttpServlet {
    private EmployeeDTOService employeeDTOService = new EmployeeDTOServiceImpl();
    private PositionService positionService = new PositionServiceImpl();
    private DepartmentService departmentService = new DepartmentServiceImpl();
    private EducationDegreeService educationDegreeService = new EducationDegreeServiceImpl();
    private EmployeeService employeeService = new EmployeeServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String username = request.getParameter("username");
        int id = Integer.parseInt(request.getParameter("id"));
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
        Employee employee = new Employee(id, name, birthday, idCard, salary, phone, email, address, position, educationDegree, department, username);
        employeeService.update(employee);
        response.sendRedirect("employee-list");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Position> positionList = positionService.findAll();
        List<EducationDegree> educationDegreeList = educationDegreeService.findAll();
        List<Department> departmentList = departmentService.findAll();
        int id = Integer.parseInt(request.getParameter("id"));
        EmployeeDTO employeeDTO = employeeDTOService.getById(id);
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        request.setAttribute("username", username);
        request.setAttribute("positionList", positionList);
        request.setAttribute("educationDegreeList", educationDegreeList);
        request.setAttribute("departmentList", departmentList);
        request.setAttribute("employee", employeeDTO);
        request.getRequestDispatcher("jsp/employee/employeeEdit.jsp").forward(request, response);
    }
}
