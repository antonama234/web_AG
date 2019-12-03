package servlets;

import Servise.UserService;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/deleteUser")
public class DeleteUserServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/delete.jsp").forward(req, resp);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService service = UserService.getInstance();
        Long id = Long.parseLong(req.getParameter("id"));
        User user = service.findUser(id);
        if (service.isExist(user)) {
            service.removeObject(user);
            resp.setStatus(HttpServletResponse.SC_OK);
        } else {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
        req.setAttribute("user", user);
        req.setAttribute("name", user.getName());
        req.setAttribute("surName", user.getSurName());
        doGet(req, resp);
        resp.setContentType("text/html;charset=utf-8");
        resp.sendRedirect("allUsers");
    }
}
