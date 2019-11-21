package servlets;

import Servise.UserService;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/allUsers")
public class AllUsersServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> allUsers = UserService.getInstance().getAllUsers();
        req.setAttribute("all", allUsers);
        RequestDispatcher dispatcher = req.getRequestDispatcher("jsp/all.jsp");
        dispatcher.forward(req, resp);
    }
}
