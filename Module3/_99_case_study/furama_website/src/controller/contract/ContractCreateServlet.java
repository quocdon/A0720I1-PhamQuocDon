package controller.contract;

import model.*;
import service.contract.AttachServiceService;
import service.contract.ContractDetailService;
import service.contract.ContractService;
import service.contract.impl.AttachServiceServiceImpl;
import service.contract.impl.ContractDetailServiceImpl;
import service.contract.impl.ContractServiceImpl;
import service.customer.CustomerService;
import service.customer.CustomerTypeService;
import service.customer.impl.CustomerServiceImpl;
import service.employee.EmployeeService;
import service.employee.impl.EmployeeServiceImpl;
import service.service.ServiceService;
import service.service.impl.ServiceServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

@WebServlet(name = "ContractCreateServlet", urlPatterns = "/contract-create")
public class ContractCreateServlet extends HttpServlet {
    AttachServiceService attachServiceService = new AttachServiceServiceImpl();
    EmployeeService employeeService = new EmployeeServiceImpl();
    CustomerService customerService = new CustomerServiceImpl();
    ServiceService serviceService = new ServiceServiceImpl();
    ContractService contractService = new ContractServiceImpl();
    ContractDetailService contractDetailService = new ContractDetailServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String contractId = contractService.generateId();
        Date startDate = null;
        Date endDate = null;
        String startDateInput = request.getParameter("startDate");
        String endDateInput = request.getParameter("endDate");
        try {
            startDate = simpleDateFormat.parse(startDateInput);
            endDate = simpleDateFormat.parse(endDateInput);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        double deposit = Double.parseDouble(request.getParameter("deposit"));
        int employeeId = Integer.parseInt(request.getParameter("employeeId"));
        String customerId = request.getParameter("customerId");
        String serviceId = request.getParameter("serviceId");
        LocalDate localStartDate = Instant.ofEpochMilli(startDate.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate localEndDate = Instant.ofEpochMilli(endDate.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
        Period period = Period.between(localStartDate, localEndDate);
        int stayPeriod = period.getDays();
        double amount = stayPeriod*serviceService.getById(serviceId).getCost();
        List<AttachService> attachServiceList = attachServiceService.findAll();
        for (AttachService attachService : attachServiceList){
            int quantity = Integer.parseInt(request.getParameter(attachService.getName()));
            amount += quantity*attachService.getCost();
            ContractDetail contractDetail = new ContractDetail(contractId, attachService.getId(),quantity);
            contractDetailService.save(contractDetail);
        }
        Contract contract = new Contract(contractId, startDate, endDate, deposit, amount, employeeId, customerId, serviceId);
        contractService.save(contract);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> employeeList = employeeService.findAll();
        List<Customer> customerList = customerService.findAll();
        List<Service>  serviceList = serviceService.findAll();
        List<AttachService> attachServiceList = attachServiceService.findAll();
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        request.setAttribute("username", username);
        request.setAttribute("employeeList", employeeList);
        request.setAttribute("customerList", customerList);
        request.setAttribute("serviceList", serviceList);
        request.setAttribute("attachServiceList", attachServiceList);
        request.getRequestDispatcher("jsp/contract/contractUpdate.jsp").forward(request, response);
    }
}
