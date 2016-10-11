package servlets;

import dao.Manager;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;


/**
 * Created by marie on 11-Oct-16.
 */
@WebServlet(name = "Greeting", urlPatterns = ("/hi"))
public class Greeting extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        Manager manager = new Manager();
        //response.getWriter().append("Hello " + username);
    }
}
