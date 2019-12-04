package servlets;

import Servise.UserService;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
    private UserService service = UserService.getInstance();

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = service.findByLogin((String) session.getAttribute("login"));
        req.setAttribute("name", user.getName());
        req.setAttribute("role", user.getRole());
        resp.setContentType("text/html;charset=utf-8");
        getServletContext().getRequestDispatcher("/user.jsp").forward(req, resp);
    }
}