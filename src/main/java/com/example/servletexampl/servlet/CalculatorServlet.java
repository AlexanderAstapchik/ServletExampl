package com.example.servletexampl.servlet;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(value = "/calc")

public class CalculatorServlet extends HttpServlet {

    public String result1;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/calc.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        double num1 = Double.parseDouble(req.getParameter("num1"));
        double num2 = Double.parseDouble(req.getParameter("num2"));
        String operation = req.getParameter("operation");
        switch (operation) {
            case "+":
                req.setAttribute("result", num1 + num2);
                break;
            case "-":
                req.setAttribute("result", num1 - num2);
                break;
            case "*":
                req.setAttribute("result", num1 * num2);
                break;
            case "/":
                req.setAttribute("result", num1 / num2);
                break;
        }

        result1= req.getParameter("result");
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection= DriverManager.getConnection("jdbc:mysql://localhost/database1","root","root");
            String query2 = "insert into calchistory (resultcalc) values(?)";
            PreparedStatement ps1=connection.prepareStatement(query2);
            ps1.setString(1,result1);

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        getServletContext().getRequestDispatcher("/pages/calc.jsp").forward(req, resp);
    }
}