package com.example.servletexampl.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(value = "/register")
public class RegisterServlet extends HttpServlet {
    String user,username, password1,password2;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         resp.setContentType("text/html");
         user=req.getParameter("name");
         username=req.getParameter("username");
         password1=req.getParameter("pass1");
         password2=req.getParameter("pass2");

        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection= DriverManager.getConnection("jdbc:mysql://localhost/database1","root","root");
            String query = "insert into users( firstname ,username,userpass1,userpass2) values(?,?,?,?)";
            PreparedStatement ps=connection.prepareStatement(query);
            ps.setString(1,user);
            ps.setString(2,username);
            ps.setString(3,password1);
            ps.setString(4,password2);

            Statement stmt=connection.createStatement();
            String query1 = "select * from users where  username='"+username+"'";
            ResultSet resultSet= stmt.executeQuery(query1);
            if(resultSet.next()){
                getServletContext().getRequestDispatcher("/failregister.jsp").forward(req, resp);
            } else {
                ps.executeUpdate();
                getServletContext().getRequestDispatcher("/pages/calc.jsp").forward(req, resp);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
