package servlet;

import models.Customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@WebServlet(name = "/index", urlPatterns = "/index")
public class CustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = new ArrayList<>();
        customerList.add(new Customer("Bruno Fernandes", "08-09-1994", "Portugal",
                "https://resources.premierleague.com/premierleague/photos/players/250x250/p141746.png"));
        customerList.add(new Customer("David De Gea", "07-11-1990", "Spain",
                "https://resources.premierleague.com/premierleague/photos/players/250x250/p51940.png"));
        customerList.add(new Customer("Edinson Cavani", "14-02-1987", "Uruguay",
                "https://resources.premierleague.com/premierleague/photos/players/250x250/p40720.png"));
        customerList.add(new Customer("Marcus Rashford", "31-10-1997", "England",
                "https://resources.premierleague.com/premierleague/photos/players/250x250/p176297.png"));
        customerList.add(new Customer("Fred", "03-05-1993", "Brazil",
                "https://resources.premierleague.com/premierleague/photos/players/250x250/p101582.png"));
        request.setAttribute("customerList", customerList);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
