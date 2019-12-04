package servlets;

import Servise.UserService;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/allUsers")
public class AllUsersServlet extends HttpServlet {
    private UserService service = UserService.getInstance();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> allUsers = service.getAllUsers();
        req.setAttribute("all", allUsers);
        getServletContext().getRequestDispatcher("/all.jsp").forward(req, resp);
    }
}
