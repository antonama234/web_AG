package servlets;

import Servise.UserService;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteUser")
public class DeleteUser extends HttpServlet {

    public void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService service = UserService.getInstance();
        Long id = Long.parseLong(req.getParameter("id"));
        User user = service.findUser(id);
        if (service.isExist(user)) {
            service.removeObject(user);
            resp.setStatus(HttpServletResponse.SC_OK);
            System.out.println("The user is delete.");
        } else {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            System.out.println("User not found.");
        }
        resp.setContentType("text/html;charset=utf-8");
    }
}
