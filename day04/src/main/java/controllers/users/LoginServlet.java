package controllers.users;

import models.users.LoginService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher rd = req.getRequestDispatcher("/user/login.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        String userPw = req.getParameter("userPw");
        // Controller - 요청 -> 적절한 서비스 찾고 실행

        // Model - 비지니스 로직(기능 - Service)
        LoginService service = new LoginService(); // 로그인 기능
        service.login(userId, userPw);

        // View - 처리 결과 응답(jsp)
        RequestDispatcher rd = req.getRequestDispatcher("/user/login_done.jsp");
        rd.forward(req, resp);
    }
}
