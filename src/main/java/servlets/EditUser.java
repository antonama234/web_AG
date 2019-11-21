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
public class EditUser extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService service = UserService.getInstance();
        Long id = Long.parseLong(req.getParameter("id"));
        String newName = req.getParameter("newName");
        String newSurName = req.getParameter("newSurName");
        Long newAge = Long.parseLong("newAge");
        User user = service.findUser(id);
        user.setName(newName);
        user.setSurName(newSurName);
        user.setAge(newAge);
        if (!service.isExist(user)) {
            service.editUser(user);
            resp.setStatus(HttpServletResponse.SC_OK);
            System.out.println("Edit success.");
        } else {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            System.out.println("User with such parameters already exists.");
        }
        resp.setContentType("text/html;charset=utf-8");
        resp.sendRedirect("/allUsers");
    }
}
