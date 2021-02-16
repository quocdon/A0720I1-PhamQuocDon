package controller;

import common.Validate;
import model.PaymentMethod;
import model.Room;
import service.PaymentMethodService;
import service.RoomService;
import service.impl.PaymentMethodServiceImpl;
import service.impl.RoomServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "RoomCreateServlet", urlPatterns = "/create")
public class RoomCreateServlet extends HttpServlet {
    private PaymentMethodService paymentMethodService = new PaymentMethodServiceImpl();
    private RoomService roomService = new RoomServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Room room = new Room();
        String name = request.getParameter("name");
        if (Validate.checkName(name)) {
            room.setRenterName(name);
        } else {
            request.setAttribute("nameFlag", "5-50 characters");
        }
        String phone = request.getParameter("phone");
        if (Validate.checkPhone(phone)) {
            room.setPhone(phone);
        } else {
            request.setAttribute("phoneFlag","Phone number has 10 digits");
        }
        String rentDate = request.getParameter("rentDate");
        room.setRentDate(rentDate);
        String paymentMethod = request.getParameter("paymentMethod");
        room.setPaymentMethod(paymentMethod);
        String remark = request.getParameter("remark");
        room.setRemark(remark);
        if (!Validate.checkPhone(phone) || !Validate.checkName(name)){
            this.doGet(request, response);
        } else {
            roomService.save(room);
            response.sendRedirect("list");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<PaymentMethod> methodList = paymentMethodService.findAll();
        request.setAttribute("methodList", methodList);
        request.getRequestDispatcher("jsp/create.jsp").forward(request, response);
    }
}
