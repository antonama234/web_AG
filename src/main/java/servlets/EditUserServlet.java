package servlets;

import Servise.UserService;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/editUser")
public class EditUserServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        req.setAttribute("id", id);
        getServletContext().getRequestDispatcher("/edit.jsp").forward(req, resp);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService service = UserService.getInstance();
        Long id = Long.parseLong(req.getParameter("id"));
        String newName = req.getParameter("newName");
        String newSurName = req.getParameter("newSurName");
        Long newAge = Long.parseLong(req.getParameter("newAge"));
        User user = service.findUser(id);
        user.setName(newName);
        user.setSurName(newSurName);
        user.setAge(newAge);
        if (!service.isExist(user)) {
            service.editUser(user);
            resp.setStatus(HttpServletResponse.SC_OK);
        } else {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
        resp.setContentType("text/html;charset=utf-8");
        resp.sendRedirect("allUsers");
    }
}
