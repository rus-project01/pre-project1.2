package Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import model.User;
import service.UserService;

@WebServlet("/serv/*")
public class UserServlet extends HttpServlet {
        UserService servletUser = new UserService();

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        servletUser.createTable();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("user", servletUser.getAllUsers());
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        Long money = Long.parseLong(req.getParameter("money"));
        servletUser.addUser(new User(name, password, money));
        req.setAttribute("user", servletUser.getAllUsers());
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
