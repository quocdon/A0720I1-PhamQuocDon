package controllers;

import services.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ListServlet", urlPatterns = "/list")
public class ListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("jsp/list.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        if (username == null || "".equals(username)) {
            response.sendRedirect("login");
            return;
        }
        CustomerService customerService = new CustomerService();
        request.setAttribute("customerList", customerService.getCustomerList());
        request.setAttribute("username", username);
        request.getRequestDispatcher("jsp/list.jsp").forward(request, response);
    }
}