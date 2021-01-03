package controllers;

import models.Calculator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CalculatorServlet", urlPatterns = "/calculator")
public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double firstOperand = 0;
        double secondOperand = 0;
        String operator = null;
        try {
            firstOperand = Double.parseDouble(request.getParameter("firstOperand"));
            secondOperand = Double.parseDouble(request.getParameter("secondOperand"));
            operator = request.getParameter("operator");
            Calculator calculator = new Calculator(firstOperand, secondOperand);
            switch (operator) {
                case "Addition":
                    request.setAttribute("result", calculator.addition());
                    request.setAttribute("operator", "+");
                    break;
                case "Subtraction":
                    request.setAttribute("result", calculator.subtraction());
                    request.setAttribute("operator", "-");
                    break;
                case "Multiple":
                    request.setAttribute("result", calculator.multiple());
                    request.setAttribute("operator", "*");
                    break;
                case "Division":
                    request.setAttribute("result", calculator.division());
                    request.setAttribute("operator", "/");
                    break;
            }
        } catch (Exception e) {
            request.setAttribute("error", "Only input number to operands & choose operator... Please try again");
        }
        request.setAttribute("firstOperand", firstOperand);
        request.setAttribute("secondOperand", secondOperand);
        request.getRequestDispatcher("jsp/calculator.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("jsp/calculator.jsp").forward(request, response);
    }
}
