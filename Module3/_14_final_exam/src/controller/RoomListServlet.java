package controller;

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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "RoomListServlet", urlPatterns = "/list")
public class RoomListServlet extends HttpServlet {
    private RoomService roomService = new RoomServiceImpl();
    private PaymentMethodService paymentMethodService = new PaymentMethodServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<PaymentMethod> methodList = paymentMethodService.findAll();
        List<Room> roomList = roomService.findAll();
        request.setAttribute("roomList", roomList);
        request.getRequestDispatcher("jsp/list.jsp").forward(request, response);
    }
}
