package tests;

import javax.servlet.http.HttpSession;

public class LoginService {
    public String check(HttpSession session) {

        String userId = (String)session.getAttribute("userId");

        return "(" + userId + ")님 로그인";
    }
}
