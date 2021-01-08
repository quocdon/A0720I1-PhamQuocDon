package controllers;

import models.Customer;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import services.CustomerService;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.*;

@WebServlet(name = "CustomerServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    public static List<Customer> customerList = new ArrayList<>();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean isMultiPart = ServletFileUpload.isMultipartContent(request);
        Map<String, String> forms = new HashMap<>();
        String image = null;
        if (isMultiPart) {
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            List items = null;
            try {
                items = upload.parseRequest(request);
            } catch (FileUploadException e) {
                e.printStackTrace();
            }

            Iterator iterator = items.iterator();
            while (iterator.hasNext()) {
                FileItem item = (FileItem) iterator.next();
                if (item.isFormField()) {
                    forms.put(item.getFieldName(), item.getString());
                } else {
                    try {
                        String itemName = item.getName();
                        image = "image\\" + itemName.substring(itemName.lastIndexOf("\\") + 1);
                        String realPath = getServletContext().getRealPath("/") + image;
                        File saveFile = new File(realPath);
                        System.out.println("Path image: " + realPath);
                        item.write(saveFile);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        String username = forms.get("username");
        String password = forms.get("password");
        String customerName = forms.get("customerName");
        String birthday = forms.get("birthday");
        String address = forms.get("address");
        CustomerService customerService = new CustomerService();
        if (customerService.checkRegister(username)) {
            Customer customer = new Customer(username, password, customerName, birthday, address, image);
            customerService.addCustomer(customer);
            response.sendRedirect("login");
            return;
        } else {
            request.setAttribute("status", "Username already exists");
            request.getRequestDispatcher("jsp/register.jsp").forward(request, response);
            return;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("jsp/register.jsp").forward(request, response);
    }
}
