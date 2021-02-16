package controller;

import dao.RoomDAO;
import dao.impl.RoomDAOImpl;
import service.RoomService;
import service.impl.RoomServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "DeleteRoomServlet", urlPatterns = "/remove")
public class DeleteRoomServlet extends HttpServlet {
    RoomService roomService = new RoomServiceImpl();
    RoomDAO roomDAO = new RoomDAOImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            roomDAO.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("list");
    }
}
