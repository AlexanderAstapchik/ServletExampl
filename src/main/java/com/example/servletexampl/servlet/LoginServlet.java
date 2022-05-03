package com.example.servletexampl.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet {

    String user,username, password;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        user=req.getParameter("name");
        username=req.getParameter("username");
        password=req.getParameter("pass1");
        PrintWriter pw=resp.getWriter();

        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection= DriverManager.getConnection("jdbc:mysql://localhost/database1","root","root");
            Statement stmt=connection.createStatement();
            String query = "select * from users where firstname='"+user+"' and username='"+username+"' and userpass1='"+password+"'";
            ResultSet resultSet= stmt.executeQuery(query);

            if(resultSet.next()){
                getServletContext().getRequestDispatcher("/pages/calc.jsp").forward(req, resp);
            } else {
                //pw.println("login entered incorrectly");
                getServletContext().getRequestDispatcher("/login1.jsp").forward(req, resp);
            }

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
