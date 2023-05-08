package controllers.members;

import models.member.LoginService;
import models.member.ServiceManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static commons.MessageUtils.*;

@WebServlet("/member/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher rd = req.getRequestDispatcher("/member/login.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            ServiceManager manager = new ServiceManager();
            LoginService service = manager.getLoginService();
            service.login(req);

            String url = req.getContextPath() + "/index.jsp";
            go(resp, url, "parent");

        } catch (RuntimeException e) {
            alertError(resp, e);
            e.printStackTrace();
        }
    }
}
