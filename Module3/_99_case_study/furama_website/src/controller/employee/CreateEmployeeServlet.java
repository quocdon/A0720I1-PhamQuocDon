package controller.employee;

import common.Validate;
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
        Validate emailValidate = new Validate("^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$");
        Validate phoneValidate = new Validate("^09[0-1]\\d{7}$|^\\(84\\)\\+9[0-1]\\d{7}$");
        Validate idCardValidate = new Validate("^\\d{9}$|^\\d{12}$");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        boolean flag = true;
        User user = new User();
        Employee employee = new Employee();
        String username = request.getParameter("username");
        if (userService.getUser(username) == null) {
            user.setUsername(username);
            employee.setUsername(username);
        } else {
            flag = false;
            request.setAttribute("usernameFlag", "Tên đăng nhập đã tồn tại");
        }
        String password = request.getParameter("password");
        user.setPassword(password);
        String name = request.getParameter("name");
        employee.setName(name);
        String birthdayInput = request.getParameter("birthday");
        Date birthday = null;
        try {
            birthday = dateFormat.parse(birthdayInput);
        } catch (ParseException e) {
            flag = false;
        }
        employee.setBirthday(birthday);
        String idCard = request.getParameter("idCard");
        if (idCardValidate.checkRegex(idCard)) {
            employee.setIdCard(idCard);
        } else {
            flag = false;
            request.setAttribute("idCardFlag", "CMND có 9 hoặc 12 số");
        }
        try {
            double salary = Double.parseDouble(request.getParameter("salary"));
            if (salary > 0) {
                employee.setSalary(salary);
            } else {
                flag = false;
                request.setAttribute("salaryFlag", "Lương phải là số dương");
            }
        } catch (Exception e) {
            flag = false;
            request.setAttribute("salaryFlag", "Lương phải là số dương");
        }
        String phone = request.getParameter("phone");
        if (phoneValidate.checkRegex(phone)) {
            employee.setPhone(phone);
        } else {
            flag = false;
            request.setAttribute("phoneFlag", "SĐT theo định dạng 090xxxxxxx-091xxxxxxx-84+90xxxxxxx-(84)91xxxxxxx");
        }
        String email = request.getParameter("email");
        if (emailValidate.checkRegex(email)) {
            employee.setEmail(email);
        } else {
            flag = false;
            request.setAttribute("emailFlag", "Email đúng định dạng sample@codegym.com");
        }
        String address = request.getParameter("address");
        employee.setAddress(address);
        int position = Integer.parseInt(request.getParameter("position"));
        employee.setPositionId(position);
        int educationDegree = Integer.parseInt(request.getParameter("educationDegree"));
        employee.setEducationDegreeId(educationDegree);
        int department = Integer.parseInt(request.getParameter("department"));
        employee.setDepartmentId(department);

        if (!flag){
            request.setAttribute("user", user);
            request.setAttribute("employee", employee);
            this.doGet(request, response);
        } else {
            userService.save(user);
            employeeService.save(employee);
            response.sendRedirect("employee-list?page=1");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Position> positionList = positionService.findAll();
        List<EducationDegree> educationDegreeList = educationDegreeService.findAll();
        List<Department> departmentList = departmentService.findAll();
        HttpSession session = request.getSession();
        String signInUser = (String) session.getAttribute("signInUser");
        request.setAttribute("signInUser", signInUser);
        request.setAttribute("positionList", positionList);
        request.setAttribute("educationDegreeList", educationDegreeList);
        request.setAttribute("departmentList", departmentList);
        request.getRequestDispatcher("jsp/employee/employeeCreate.jsp").forward(request, response);
    }
}
