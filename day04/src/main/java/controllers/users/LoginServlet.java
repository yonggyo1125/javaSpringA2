package controllers.users;

import models.users.LoginService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 컨트롤러(Controller)

        // 요청 -> 서비스 로직 실행(Model)
        LoginService service = new LoginService();
        service.login(req);

        RequestDispatcher rd = req.getRequestDispatcher("/user/login.jsp"); //뷰(jsp)
        rd.include(req, resp); // View
    }
}
