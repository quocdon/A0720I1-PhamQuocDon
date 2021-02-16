package controller.service;

import model.RentType;
import model.Service;
import model.ServiceType;
import service.service.RentTypeService;
import service.service.ServiceService;
import service.service.ServiceTypeService;
import service.service.impl.RentTypeServiceImpl;
import service.service.impl.ServiceServiceImpl;
import service.service.impl.ServiceTypeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CreateServiceServlet", urlPatterns = "/service-create")
public class CreateServiceServlet extends HttpServlet {
    private RentTypeService rentTypeService = new RentTypeServiceImpl();
    private ServiceTypeService serviceTypeService = new ServiceTypeServiceImpl();
    private ServiceService serviceService = new ServiceServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = serviceService.generateId();
        String name = request.getParameter("name");
        int area = Integer.parseInt(request.getParameter("area"));
        double cost = Double.parseDouble(request.getParameter("cost"));
        int maxPeople = Integer.parseInt(request.getParameter("maxPeople"));
        int rentTypeId = Integer.parseInt(request.getParameter("rentType"));
        int serviceTypeId = Integer.parseInt(request.getParameter("serviceType"));
        Service service = new Service(id, name, area, cost, maxPeople, rentTypeId, serviceTypeId);
        serviceService.save(service);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<RentType> rentTypeList = rentTypeService.findAll();
        List<ServiceType> serviceTypeList = serviceTypeService.findAll();
        HttpSession session = request.getSession();
        String signInUser = (String) session.getAttribute("signInUser");
        request.setAttribute("signInUser", signInUser);
        request.setAttribute("rentTypeList", rentTypeList);
        request.setAttribute("serviceTypeList", serviceTypeList);
        request.getRequestDispatcher("jsp/service/serviceCreate.jsp").forward(request, response);
    }
}
