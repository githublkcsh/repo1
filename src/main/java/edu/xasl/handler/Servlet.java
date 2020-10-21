package edu.xasl.handler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servlet",value = "/servlet")
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        String role_name = request.getParameter("role_name");
        String functions = request.getParameter("functions");
        String[] functionArray = functions.split("\\.");
        System.out.println(functions);
        System.out.println(functionArray.length);
        for (int n = 0; n < functionArray.length; n++) {
            System.out.println(functionArray[n]);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
