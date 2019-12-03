package servlets;

import Servise.UserService;
import model.User;
import util.DBProperties;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Properties;

@WebServlet("/index")
public class MainPageServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService service = UserService.getInstance();
        Properties properties = DBProperties.getMyProperties();
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        User user = service.findByLogin(login);
        if (properties.getProperty("admin_login").equals(login) && properties.getProperty("admin_password").equals(password)) {
            user.setRole("admin");
            resp.sendRedirect("admin/allUsers");
            resp.setStatus(HttpServletResponse.SC_OK);
        } else if (user.getPassword().equals(password)) {
            user.setRole("user");
            service.editUser(user);
            resp.sendRedirect("user");
            resp.setStatus(HttpServletResponse.SC_OK);
        } else {
            System.out.println("User not found.");
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
        HttpSession session = req.getSession();
        session.setAttribute("login", login);
        session.setAttribute("role", user.getRole());
        resp.setContentType("text/html;charset=utf-8");
    }
}
